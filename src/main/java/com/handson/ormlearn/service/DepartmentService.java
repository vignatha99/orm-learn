package com.handson.ormlearn.service;

import com.handson.ormlearn.model.Department;

public interface DepartmentService {

	Department findDepartment(int id);

	void saveDepartment(Department department);
}