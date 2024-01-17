package com.qsp.student_management.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="Name Cannot be Blank")
	@NotNull(message="Name cannot be null")
	private String name;
	@Column(unique = true)
	//@Min(value = 60000000000l)
	//@Max(value = 99999999999l)
	
	private long phone;
	@NotBlank(message="City Cannot be Blank")
	@NotNull(message="City cannot be null")
	private String city;
	@Column(unique = true)
	@Email(regexp =  "[a-z0-9._$]+@[a-z]+\\.[a-z]{2,3}",message="Invalid")
	private String email;
	private int age;
	private char gender;
	private int obtainMarks;
	private int totalMarks;
	private double percentage;
	private String grade;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Student(int id, String name, long phone, String city, String email, int age, char gender, int obtainMarks,
			int totalMarks, double percentage, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.obtainMarks = obtainMarks;
		this.totalMarks = totalMarks;
		this.percentage = percentage;
		this.grade=grade;
		
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public int getObtainMarks() {
		return obtainMarks;
	}
	public void setObtainMarks(int obtainMarks) {
		this.obtainMarks = obtainMarks;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	
	
	
}
