package com.handson.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.handson.ormlearn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = 1")
	List<Employee> getAllPermanentEmployees();
	
	@Query("select avg(e.salary) from Employee e ")
	double getAverageSalary();
	
	@Query(value="SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
	double getAverageSalaryBasedOnDeptId(@Param("id") int id);
	
	//Avoiding native queries helps in easier portability of databases
	@Query(value="SELECT * FROM employee", nativeQuery = true)
	List<Employee> getAllEmployeesNative();
}