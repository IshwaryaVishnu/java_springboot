package se.lexicon.java_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.java_springboot.dao.AddressDao;
import se.lexicon.java_springboot.dao.StudentDao;
import se.lexicon.java_springboot.entity.Address;
import se.lexicon.java_springboot.entity.Student;

import java.time.LocalDate;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    @Autowired
    StudentDao studentDao;

    @Autowired
    AddressDao addressDao;
@Transactional
    @Override
    public void run(String... args) throws Exception {
    exe1();
    }

    public  void exe1() {
        Address addressData = new Address("almhult","Hjorthvegan","34336");
        Address createdAddress = addressDao.persist(addressData);


        Student studentData = new Student("ishu","Sankar","ishu27.v@gmail.com",LocalDate.parse("1991-09-27"));
        studentData.setAddress(createdAddress);
        Student createdStudent = studentDao.persist(studentData);
    }
}

