
package com.dao;

import java.util.List;

import com.model.Employee;



public interface EmployeeDao {
	
	List<Employee> readFromFile();
	void writeToDatabase(List<Employee> list);

}
