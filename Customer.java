package com.scb.creditcard.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@Column(name = "customer_Name")
	private String customerName;
	
	@Column(name = "customer_Email")
	private String customerEmail;
	
	@Column(name = "pan_Number")
	private String panNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "mobile_No")
	private String mobileNo;
	
	@Column(name = "income")
	private int income;
	
	public Customer()
	{
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerEmail=" + customerEmail
				+ ", panNumber=" + panNumber + ", address=" + address + ", mobileNo=" + mobileNo + ", income=" + income
				+ "]";
	}


	

}
