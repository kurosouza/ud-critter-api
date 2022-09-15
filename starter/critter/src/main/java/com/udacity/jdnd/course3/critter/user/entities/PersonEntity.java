package com.udacity.jdnd.course3.critter.user.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "people")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Nationalized
	private String name;

	public PersonEntity() {}
	
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
