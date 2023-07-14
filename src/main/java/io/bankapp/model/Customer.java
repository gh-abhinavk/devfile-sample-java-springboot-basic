package io.bankapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private int acctID;
	private String custName;
	private String city;
	private String state;
	private String country;
	private int phoneNo;
	private String password;
	private String pan;

	public Customer() {

	}

	public Customer(int acctID, String custName, String city, String state, String country, int phoneNo,
			String password,String pan) {
		super();
		this.acctID = acctID;
		this.custName = custName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNo = phoneNo;
		this.password = password;
		this.pan = pan;
	}

	public int getAcctID() {
		return acctID;
	}

	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"acctID=" + acctID +
				", custName='" + custName + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", country='" + country + '\'' +
				", phoneNo=" + phoneNo +
				", password='" + password + '\'' +
				", pan='" + pan + '\'' +
				'}';
	}
}
