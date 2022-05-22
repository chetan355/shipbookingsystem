package com.algo.onlineshipbooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;	
	private String fName;
	private String lName;
	@Column(unique = true)
	private String email;
	private int age;
	private String gender;
	private String password;
	private String address;
	private String phoneNumber;
	private String role;
	public User(){
		
	}
	public User(String f_name, String l_name, String email,int age, String gender, String password, String address,
			String phoneNumber,String role) 
	{
		super();
		this.fName = f_name;
		this.lName = l_name;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", fName=" + fName + ", lName=" + lName + ", age=" + age + ", gender="
				+ gender + ", password=" + password + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
}
