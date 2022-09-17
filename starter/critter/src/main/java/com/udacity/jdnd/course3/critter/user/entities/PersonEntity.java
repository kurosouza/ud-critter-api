package com.udacity.jdnd.course3.critter.user.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Nationalized;

@MappedSuperclass
public abstract class PersonEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Nationalized
	protected String name;

	public PersonEntity() { }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
