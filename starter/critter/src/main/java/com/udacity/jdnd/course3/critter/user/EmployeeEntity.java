package com.udacity.jdnd.course3.critter.user;

import java.time.DayOfWeek;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class EmployeeEntity extends PersonEntity {

	@ElementCollection
	private Set<EmployeeSkill> skills;
	
	@ElementCollection
	private Set<DayOfWeek> daysAvailable;
	
}
