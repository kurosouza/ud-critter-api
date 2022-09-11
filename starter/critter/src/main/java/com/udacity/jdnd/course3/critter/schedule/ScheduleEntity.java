package com.udacity.jdnd.course3.critter.schedule;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.pet.PetEntity;
import com.udacity.jdnd.course3.critter.user.EmployeeEntity;

@Entity
@Table(name = "schedule")
public class ScheduleEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private LocalDate date;
	
	@ManyToMany
	@JoinTable(
			name = "employees_schedule",
			joinColumns = {@JoinColumn(name = "schedule_id")},
			inverseJoinColumns = {@JoinColumn(name = "employee_id")}
	)
	private Set<EmployeeEntity> employees;
	
	@ManyToMany
	@JoinTable(name = "pets_schedule",
		joinColumns = {@JoinColumn(name = "schedule_id")},
		inverseJoinColumns = {@JoinColumn(name = "pet_id")}
	)
	private Set<PetEntity> pets;
	
	private ScheduleEntity() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Set<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public Set<PetEntity> getPets() {
		return pets;
	}

	public void setPets(Set<PetEntity> pets) {
		this.pets = pets;
	}
	
	
}
