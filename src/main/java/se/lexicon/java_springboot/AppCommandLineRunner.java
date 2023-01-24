package se.lexicon.java_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.java_springboot.dao.AddressDao;
import se.lexicon.java_springboot.dao.BookDao;
import se.lexicon.java_springboot.dao.StudentDao;
import se.lexicon.java_springboot.entity.Address;
import se.lexicon.java_springboot.entity.Book;
import se.lexicon.java_springboot.entity.Student;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    @Autowired
    StudentDao studentDao;

    @Autowired
    AddressDao addressDao;

    @Autowired
    BookDao bookDao;


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        exe3();
    }


    public void exe1() {
        Address addressData = new Address("almhult", "Hjorthvegan", "34336");
        Address createdAddress = addressDao.persist(addressData);


        Student studentData = new Student("ishu", "Sankar", "ishu27.v@gmail.com", LocalDate.parse("1991-09-27"));
        studentData.setAddress(createdAddress);
        Student createdStudent = studentDao.persist(studentData);
    }

    public void exe2() {
        Student studentData = new Student(
                "ishu",
                "Sankar",
                "ishu27.v@gmail.com",
                LocalDate.parse("1991-09-27"),
                new Address("almhult", "Hjorthvegan", "34336"));
        Student createdStudent = studentDao.persist(studentData);
        studentDao.remove(createdStudent.getId());

    }

    public void exe3() {
        Student studentData = new Student(
                "ishu",
                "Sankar",
                "ishu27.v@gmail.com",
                LocalDate.parse("1991-09-27"),
                new Address("almhult", "Hjorthvegan", "34336"));
        Student createdStudent = studentDao.persist(studentData);

        addressDao.findAll().forEach(address -> {
            System.out.println(address);
            System.out.println(address.getStudent());
        });

    }

    public void exe4() {
        Student studentData = new Student(
                "ishu",
                "Sankar",
                "ishu27.v@gmail.com",
                LocalDate.parse("1991-09-27"),
                new Address("almhult", "Hjorthvegan", "34336"));
        Student createdStudent = studentDao.persist(studentData);
        Book ocaBookData = new Book("OCA");
        Book ocpBookData = new Book("OCP");

        ocaBookData.setBorrower(createdStudent);
        //ocpBookData.setBorrower(createdStudent);

        Book createdOcaBook = bookDao.persist(ocaBookData);
        Book createdOcpBook = bookDao.persist(ocpBookData);


        createdStudent.borrowBook(createdOcpBook);
        createdStudent.returnBook(createdOcaBook);

        Optional<Student> optionalStudent = studentDao.findById(createdStudent.getId());
        if (optionalStudent.isPresent()){
            System.out.println(optionalStudent.get().getBorrowedBooks().size());
        }


        studentDao.remove(createdStudent.getId());

    }



}

