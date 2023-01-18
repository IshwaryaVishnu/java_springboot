package se.lexicon.java_springboot.dao;

import org.springframework.stereotype.Repository;
import se.lexicon.java_springboot.model.Student;

import java.util.Collection;
import java.util.Optional;

@Repository
        public class StudentDaoImpl implements StudentDao{

    @Override
    public Student persist(Student student) {
        return null;
    }

    @Override
    public Optional<Student> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public void remove(String id) {

    }
}
