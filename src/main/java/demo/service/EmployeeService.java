package demo.service;

import java.util.List;

import demo.dto.EmployeeRequest;
import demo.entity.Employee;

public interface EmployeeService {
	
	Employee createEmployee(EmployeeRequest request);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(Integer id);
	
	Employee updateEmployee(Integer id, EmployeeRequest request);
	
	void deleteEmployee(Integer id);
	

}
