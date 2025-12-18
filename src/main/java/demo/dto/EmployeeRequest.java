package demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class EmployeeRequest {
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Gender is required")
	private String gender;
	
	@Positive(message = "Salary must be positive")
	private Double salary;
	
	@NotBlank(message = "PAN is required")
	private String pan;

	public EmployeeRequest( String name,String gender,	Double salary,String pan) {
		super();
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.pan = pan;
	}

	public String getName() {
		return name;
	}

	public EmployeeRequest() {
		
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [name=" + name + ", gender=" + gender + ", salary=" + salary + ", pan=" + pan + "]";
	}
	
	
	
	

}
