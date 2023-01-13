package com.springbootex.springdatajpa.example.repository;

import com.springbootex.springdatajpa.example.entity.Guardian;
import com.springbootex.springdatajpa.example.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("Krish@gmail.com")
                .firstName("Krish")
                .lastName("Patel")
//                .guardianName("Kishan")
//                .guardianEmail("Kishan@gmail.com")
//                .guardianMobile("9874685787")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("Kishan@gmail.com")
                .name("Kishan")
                .mobile("9874685787")
                .build();
        Student student = Student.builder()
                .firstName("Pankaj").
                emailId("Pankaj@gmail.com").
                lastName("Mohite").
                guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                 studentRepository.findByFirstName("Pankaj");
        System.out.println("Students = "+students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("Pankaj");
        System.out.println("Students = "+students);
    }

    @Test
     public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Kishan");
        System.out.println("Students = "+students);
    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress
                        ("Krish@gmail.com");
        System.out.println("Student = "+student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstname =
                studentRepository.getStudentFirstNameByEmailAddress
                        ("Pankaj@gmail.com");
        System.out.println("firstName = "+firstname);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "Pankaj@gmail.com");
        System.out.println("Student = "+student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "Pankaj@gmail.com");
        System.out.println("Student = "+student);
    }

    @Test
    public void printUpdateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId(
                "Krish Kallu",
                "Krish@gmail.com");
    }

}