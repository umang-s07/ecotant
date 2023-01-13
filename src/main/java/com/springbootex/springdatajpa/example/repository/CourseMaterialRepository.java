package com.springbootex.springdatajpa.example.repository;

import com.springbootex.springdatajpa.example.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.JavaBean;
@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {

}
