package se.lexicon.java_springboot.dao;

import se.lexicon.java_springboot.entity.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentDao {

    Student persist(Student student);
    Optional<Student> findById(String id);
    Optional<Student> findByEmail(String email);
    Collection<Student> findByNameContains(String name);
    Collection<Student> findAll();
    Student update(Student student);
    void remove(String id);

}
