package com.udacity.jdnd.course3.critter.user;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.schedule.ScheduleEntity;

@Entity
@Table(name = "employees")
public class EmployeeEntity extends PersonEntity {

	@ElementCollection
	private Set<EmployeeSkill> skills;
	
	@ElementCollection
	private Set<DayOfWeek> daysAvailable;
	
	@ManyToMany(mappedBy = "employees")
	private List<ScheduleEntity> schedule;

	public Set<EmployeeSkill> getSkills() {
		return skills;
	}

	public void setSkills(Set<EmployeeSkill> skills) {
		this.skills = skills;
	}

	public Set<DayOfWeek> getDaysAvailable() {
		return daysAvailable;
	}

	public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
		this.daysAvailable = daysAvailable;
	}

	public List<ScheduleEntity> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<ScheduleEntity> schedule) {
		this.schedule = schedule;
	}
	
	
}
