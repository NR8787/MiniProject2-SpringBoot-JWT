package demo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import demo.dto.EmployeeRequest;
import demo.entity.Employee;
import demo.exception.ResourceNotFoundException;
import demo.repo.EmployeeRepository;
import demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private  final EmployeeRepository employeeRepository;
	
	private static final Logger log =LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
   
	  // create 
	@Override
	public Employee createEmployee(EmployeeRequest request) {
		log.info("Creating employee with PAN : {}",request.getPan());
		     Employee employee    =  mapToEntity(request);
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		log.info("Fetching employee with id : {}" ,id);
	return employeeRepository.findById(id).orElseThrow(() ->
	                                      new ResourceNotFoundException("Employee not found with id : " + id));
	                             
		
	}

	@Override
	public Employee updateEmployee(Integer id, EmployeeRequest request) {
		log.info("Updating employee with id : {}",id);
	Employee existing = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : " + id));
	                        existing.setName(request.getName());
	                        existing.setGender(request.getGender());
	                        existing.setSalary(request.getSalary());
	                        existing.setPan(request.getPan());
	                        return employeeRepository.save(existing);
	                        
	}

	@Override
	public void deleteEmployee(Integer id) {
		log.info("Deleting employee with id : {}",id);
	Employee employee =	      employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : " + id));
	                                      employeeRepository.delete(employee);	
	}
	
	private Employee mapToEntity(EmployeeRequest request) {
		Employee emp = new Employee();
		emp.setName(request.getName());
		emp.setGender(request.getGender());
		emp.setSalary(request.getSalary());
		emp.setPan(request.getPan());
		return emp;
	}

}
