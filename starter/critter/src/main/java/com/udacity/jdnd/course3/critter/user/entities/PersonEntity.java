package com.udacity.jdnd.course3.critter.user.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "people")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PersonEntity {
	
	@Id
	@TableGenerator(name = "person_gen", table = "id_generator", pkColumnName = "name", valueColumnName = "seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "person_gen")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
