package com.udacity.jdnd.course3.critter.schedule.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.basictypes.EmployeeSkill;
import com.udacity.jdnd.course3.critter.pet.entities.PetEntity;
import com.udacity.jdnd.course3.critter.user.entities.EmployeeEntity;


@Entity
@Table(name = "schedule")
public class ScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	
	@ManyToMany
	@JoinTable(
			name = "employees_schedule",
			joinColumns = {@JoinColumn(name = "schedule_id")},
			inverseJoinColumns = {@JoinColumn(name = "employee_id")}
	)
	private List<EmployeeEntity> employees;
	
	@ManyToMany
	@JoinTable(name = "pets_schedule",
		joinColumns = {@JoinColumn(name = "schedule_id")},
		inverseJoinColumns = {@JoinColumn(name = "pet_id")}
	)
	private List<PetEntity> pets;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection
	private Set<EmployeeSkill> activities;
	
	public ScheduleEntity() { }

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

	public List<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public List<PetEntity> getPets() {
		return pets;
	}

	public void setPets(List<PetEntity> pets) {
		this.pets = pets;
	}

	public Set<EmployeeSkill> getActivities() {
		return activities;
	}

	public void setActivities(Set<EmployeeSkill> activities) {
		this.activities = activities;
	}
	
	
	
}
