package com.udacity.jdnd.course3.critter.pet.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import com.udacity.jdnd.course3.critter.basictypes.PetType;
import com.udacity.jdnd.course3.critter.schedule.entities.ScheduleEntity;
import com.udacity.jdnd.course3.critter.user.entities.CustomerEntity;



@Entity
@Table(name = "pets")
public class PetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private PetType petType;
	
	@Nationalized
	private String name;
	
	private LocalDate birthDate;
	
	@Column(name="notes", length = 512)
	private String notes;
	
	@ManyToOne
	private CustomerEntity owner;
	
	@ManyToMany(mappedBy = "pets")
	private Set<ScheduleEntity> schedule;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public CustomerEntity getOwner() {
		return owner;
	}

	public void setOwner(CustomerEntity owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "PetEntity [id=" + id + ", petType=" + petType + ", name=" + name + ", birthDate=" + birthDate
				+ ", notes=" + notes + "]";
	}
	
	
	
}
