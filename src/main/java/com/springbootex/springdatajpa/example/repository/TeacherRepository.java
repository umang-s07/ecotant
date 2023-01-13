package com.springbootex.springdatajpa.example.repository;

import com.springbootex.springdatajpa.example.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {


}
