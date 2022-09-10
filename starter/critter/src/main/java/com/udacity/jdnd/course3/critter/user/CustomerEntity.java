package com.udacity.jdnd.course3.critter.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerEntity extends PersonEntity {

	private String phoneNumber;

	@Column(name = "notes", length = 512)
	private String notes;
	
	public CustomerEntity() {
		super();
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
