package com.rh;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaccation")
public class Vaccation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Column(name = "id_emp")
    private int id_emp;
 
	@Column(name = "number_days")
    private String number_days;
 
    @Column(name = "consumed_days")
    private String consumed_days;
    
    @Column(name = "remaining_days")
    private String remaining_days;

	public int getId_emp() {
		return id_emp;
	}

	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}

	public String getNumber_days() {
		return number_days;
	}

	public void setNumber_days(String number_days) {
		this.number_days = number_days;
	}

	public String getConsumed_days() {
		return consumed_days;
	}

	public void setConsumed_days(String consumed_days) {
		this.consumed_days = consumed_days;
	}

	public String getRemaining_days() {
		return remaining_days;
	}

	public void setRemaining_days(String remaining_days) {
		this.remaining_days = remaining_days;
	}
	
    
    
    
    
}
