package revature.project.banking.models;

import java.util.Objects;

public class Customer {

	private Integer cus_id;
	private String cus_name;
	private String cus_phone;
	private Double cus_balance;
	private Integer login_id;
	private String cus_status;
	
	
	public Customer() {	}

	public Customer(Integer cus_id, String cus_name, String cus_phone, Double cus_balance, Integer login_id,
			String cus_status) {
		super();
		this.cus_id = cus_id;
		this.cus_name = cus_name;
		this.cus_phone = cus_phone;
		this.cus_balance = cus_balance;
		this.login_id = login_id;
		this.cus_status = cus_status;
	}
	public Integer getCus_id() {
		return cus_id;
	}
	public void setCus_id(Integer cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public String getCus_phone() {
		return cus_phone;
	}
	public void setCus_phone(String cus_phone) {
		this.cus_phone = cus_phone;
	}
	public Double getCus_balance() {
		return cus_balance;
	}
	public void setCus_balance(Double cus_balance) {
		this.cus_balance = cus_balance;
	}
	public Integer getLogin_id() {
		return login_id;
	}
	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}
	public String getCus_status() {
		return cus_status;
	}
	public void setCus_status(String cus_status) {
		this.cus_status = cus_status;
	}
	@Override
	public String toString() {
		return "Customer [cus_id=" + cus_id + ", cus_name=" + cus_name + ", cus_phone=" + cus_phone + ", cus_balance="
				+ cus_balance + ", login_id=" + login_id + ", cus_status=" + cus_status + "]\n";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cus_balance, cus_id, cus_name, cus_phone, cus_status, login_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(cus_balance, other.cus_balance) && cus_id == other.cus_id
				&& Objects.equals(cus_name, other.cus_name) && Objects.equals(cus_phone, other.cus_phone)
				&& Objects.equals(cus_status, other.cus_status) && login_id == other.login_id;
	}
	
	
}  
