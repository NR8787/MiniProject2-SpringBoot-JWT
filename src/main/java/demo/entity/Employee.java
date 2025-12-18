package demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="employees",uniqueConstraints = {@UniqueConstraint(columnNames = "pan")})
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Integer id;
	
	@Column(nullable = false,length = 100)
	private String name;
	
	@Column(nullable = false,length = 10)
	private String gender;
	
	@Column(nullable = false)
	private Double salary;
	
	@Column(nullable = false,length = 10,unique = true)
	private String pan;
	
	public Employee() {
		
	}

	public Employee( String name, String gender, Double salary, String pan) {
		super();
	
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.pan = pan;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
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
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary + ", pan=" + pan
				+ "]";
	}
	
	

}
