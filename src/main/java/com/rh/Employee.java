package com.rh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
 
    @Column(name = "first_name")
    private String first_name;
 
	@Column(name = "last_name")
    private String last_name;
 
    @Column(name = "age")
    private String age;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "post")
    private String post;
    
    @Column(name = "hiring_date")
    private String hiring_date;
    
    @Column(name = "department")
    private String department;
    
    @Column(name = "salary")
    private String salary;
	
    @Column(name = "end_date")
    private String end_date;
    
    @Column(name = "cin")
    private String cin;
    
    @Column(name = "type_contrat")
    private String type_contrat;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "archived")
    private String archived;
    
    @Column(name = "photo")
    private String photo;
    
    

    public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getArchived() {
		return archived;
	}

	public void setArchived(String archived) {
		this.archived = archived;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getHiring_date() {
		return hiring_date;
	}

	public void setHiring_date(String hiring_date) {
		this.hiring_date = hiring_date;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getType_contrat() {
		return type_contrat;
	}

	public void setType_contrat(String type_contrat) {
		this.type_contrat = type_contrat;
	}

    
    
}
