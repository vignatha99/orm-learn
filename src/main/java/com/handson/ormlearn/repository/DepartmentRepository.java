package com.handson.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handson.ormlearn.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
}