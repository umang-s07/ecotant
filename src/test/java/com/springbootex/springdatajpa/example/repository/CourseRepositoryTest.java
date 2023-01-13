package com.springbootex.springdatajpa.example.repository;

import com.springbootex.springdatajpa.example.entity.Course;
import com.springbootex.springdatajpa.example.entity.Student;
import com.springbootex.springdatajpa.example.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses =
                courseRepository.findAll();

        System.out.println("courses = " + courses);

    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Dheeraj")
                .lastName("Shukla")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        PageRequest firstPageWithThreeRecords =
                PageRequest.of(0, 3);

        PageRequest secondPageWithThreeRecords =
                PageRequest.of(1, 2);

        List<Course> courses =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getContent();
        long totalElements =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalElements();
        long totalPages =
                courseRepository.findAll(firstPageWithThreeRecords)
                        .getTotalPages();
        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        PageRequest sortByTitle =
                PageRequest.of(0, 2,
                        Sort.by
                                ("title"));
        Pageable sortByCreditDesc =
                PageRequest.of(0, 2,
                        Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0, 2,
                        Sort.by("title").descending()
                                .and(Sort.by
                                        ("credit")));

        List<Course> courses =
                courseRepository.findAll(sortByTitle)
                        .getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D",
                        firstPageTenRecords
                ).getContent();

        System.out.println("courses = "+courses);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher =
                Teacher.builder()
                        .firstName("Ram")
                        .lastName("Narayana")
                        .build();

        Student student = Student.builder()
                .firstName("Ankur")
                .lastName("Kol")
                .emailId("Ankur@gmail.com")
                .build();

        Course course = Course
                .builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);
    }
}