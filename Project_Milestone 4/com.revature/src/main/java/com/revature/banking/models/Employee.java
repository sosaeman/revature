package com.revature.banking.models;

import java.util.Objects;

public class Employee {
	private Integer emp_id;
	private String emp_name;
	private String emp_title;
	private Double emp_salary;
	private Integer login_id;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Integer emp_id, String emp_name, String emp_title, Double emp_salary, Integer login_id) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_title = emp_title;
		this.emp_salary = emp_salary;
		this.login_id = login_id;
	}

	public Integer getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_title() {
		return emp_title;
	}

	public void setEmp_title(String emp_title) {
		this.emp_title = emp_title;
	}

	public Double getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(Double emp_salary) {
		this.emp_salary = emp_salary;
	}

	public Integer getLogin_id() {
		return login_id;
	}

	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_title=" + emp_title + ", emp_salary="
				+ emp_salary + ", login_id=" + login_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(emp_id, emp_name, emp_salary, emp_title, login_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(emp_id, other.emp_id) && Objects.equals(emp_name, other.emp_name)
				&& Objects.equals(emp_salary, other.emp_salary) && Objects.equals(emp_title, other.emp_title)
				&& Objects.equals(login_id, other.login_id);
	}
	
}
