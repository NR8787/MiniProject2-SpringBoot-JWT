package demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.dto.EmployeeRequest;
import demo.entity.Employee;
import demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Employee Controller",description = "API for maneging employees")
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeRequest request) {
	Employee saveEmployee	  =  employeeService.createEmployee(request);
	return ResponseEntity.status(HttpStatus.CREATED).body(saveEmployee);
	}
	
	@Operation(summary = "Get all employee")
	@ApiResponse(responseCode = "200",description = "Successfully retrieved list")
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee employee =       employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@Valid @RequestBody EmployeeRequest request) {
		       Employee updateemployee =  employeeService.updateEmployee(id, request);
		       return ResponseEntity.ok(updateemployee);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		   employeeService.deleteEmployee(id);
		 return ResponseEntity.ok("Employee with ID " + id + "deleted Successfully.");
	}
}
