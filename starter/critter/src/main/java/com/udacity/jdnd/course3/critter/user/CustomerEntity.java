package com.udacity.jdnd.course3.critter.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.pet.PetEntity;

@Entity
@Table(name = "customers")
public class CustomerEntity extends PersonEntity {

	private String phoneNumber;

	@Column(name = "notes", length = 512)
	private String notes;
	
	@OneToMany(mappedBy = "owner")
	private List<PetEntity> pets;
	
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

	public List<PetEntity> getPets() {
		return pets;
	}

	public void setPets(List<PetEntity> pets) {
		this.pets = pets;
	}
	
	
	
}
