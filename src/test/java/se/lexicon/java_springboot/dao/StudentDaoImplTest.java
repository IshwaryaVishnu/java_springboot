package se.lexicon.java_springboot.dao;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.java_springboot.entity.Student;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@AutoConfigureTestEntityManager
@DirtiesContext
public class StudentDaoImplTest {


    @Autowired
    TestEntityManager em;

    @Autowired
    StudentDaoImpl testObject;

    String createdStudentId1;
    String createdStudentId2;

    @BeforeEach
    public void setup() {
        Student studentData1 = new Student("ishu", "Sankar", "ishu27.v@gmail.com", LocalDate.parse("1991-09-27"));
        Student studentData2 = new Student("anjali", "menon", "anjalimenon@gmail.com", LocalDate.parse("1991-07-01"));

        Student createdStudent1 = em.persist(studentData1);
        Student createdStudent2 = em.persist(studentData2);

        createdStudentId1 = createdStudent1.getId();
        createdStudentId2 = createdStudent2.getId();

    }

    @Test
    public void persist(){
        Student studentData = new Student("sweety", "Peter", "sweety27@gmail.com", LocalDate.parse("1990-06-02"));
        Student createdStudent = testObject.persist(studentData);

        assertNotNull(createdStudent);
        assertNotNull(createdStudent.getId());


    }


}