package se.lexicon.java_springboot.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.java_springboot.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

@Repository
        public class StudentDaoImpl implements StudentDao{
    @PersistenceContext
       EntityManager entityManager;
@Transactional
    @Override
    public Student persist(Student student) {
        entityManager.persist(student);
        return null;
    }
@Transactional(readOnly = true)
    @Override
    public Optional<Student> findById(String id) {
        return Optional.ofNullable(entityManager.find(Student.class,id));
    }
@Transactional(readOnly = true)
    @Override
    public Optional<Student> findByEmail(String email) {
        return entityManager.createQuery("select s from Student s where UPPER(s.email) = UPPER(:e)", Student.class)
                .setParameter("e", email)
                .getResultStream()
                .findFirst();
    }
@Transactional(readOnly = true)
    @Override
    public Collection<Student> findByNameContains(String name) {
        return entityManager.createQuery("select s from Student s " +
                        "where " +
                        "UPPER(s.firstName) LIKE UPPER(CONCAT('%', :name, '%'))" +
                        " OR  " +
                        "UPPER(s.lastName) LIKE UPPER(CONCAT('%', :name, '%'))", Student.class)
                .setParameter("name", name)
                .getResultList();

    }
@Transactional(readOnly = true)
    @Override
    public Collection<Student> findAll() {
        return entityManager.
                createQuery("select s from Student s", Student.class)
                .getResultList();
    }
@Transactional
    @Override
    public Student update(Student student) {
    return entityManager.merge(student);
    }
@Transactional
    @Override
    public void remove(String id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) entityManager.remove(student);
        //else // throw exception...
    }

}
