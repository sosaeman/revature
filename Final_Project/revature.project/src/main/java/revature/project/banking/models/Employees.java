package revature.project.banking.models;

import java.util.Objects;

public class Employees {

	private int emp_id;
	private String emp_name;
	private String emp_phone;
	private int login_id;
	private String emp_title;
	public Employees() {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_phone = emp_phone;
		this.login_id = login_id;
		this.emp_title = emp_title;
	}
	
	
	public Employees(int emp_id, String emp_name, String emp_phone, int login_id, String emp_title) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_phone = emp_phone;
		this.login_id = login_id;
		this.emp_title = emp_title;
	}


	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getEmp_title() {
		return emp_title;
	}
	public void setEmp_title(String emp_title) {
		this.emp_title = emp_title;
	}
	@Override
	public String toString() {
		return "Employees [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_phone=" + emp_phone + ", login_id="
				+ login_id + ", emp_title=" + emp_title + "]\n";
	}
	@Override
	public int hashCode() {
		return Objects.hash(emp_id, emp_name, emp_phone, emp_title, login_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employees other = (Employees) obj;
		return emp_id == other.emp_id && Objects.equals(emp_name, other.emp_name)
				&& Objects.equals(emp_phone, other.emp_phone) && Objects.equals(emp_title, other.emp_title)
				&& login_id == other.login_id;
	}
	
	
}
