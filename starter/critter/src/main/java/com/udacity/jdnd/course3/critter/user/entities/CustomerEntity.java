package com.udacity.jdnd.course3.critter.user.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.pet.entities.PetEntity;

@Entity
@Table(name = "customers")
@NamedQueries({
		@NamedQuery(name = "Customer.findByPet", query = "Select c from CustomerEntity c where :pet member of c.pets") })
public class CustomerEntity extends PersonEntity {

	private String phoneNumber;

	@Column(name = "notes", length = 512)
	private String notes;

	@OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
	private List<PetEntity> pets = new ArrayList<>();

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
