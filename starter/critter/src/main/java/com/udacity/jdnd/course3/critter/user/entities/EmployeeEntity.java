package com.udacity.jdnd.course3.critter.user.entities;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.basictypes.EmployeeSkill;
import com.udacity.jdnd.course3.critter.schedule.entities.ScheduleEntity;


@NamedQueries({
//	@NamedQuery(name = "Employee.FindEmployeesBySkillsAndDate", query = "Select e from EmployeeEntity e where :skills = some elements(e.skills) and :days = any elements( e.daysAvailable)")
//	@NamedQuery(name = "Employee.FindEmployeesBySkillsAndDate", query = "Select e from EmployeeEntity e JOIN e.skills s where s in :skills and :day in e.daysAvailable")
	@NamedQuery(name = "Employee.FindEmployeesBySkillsAndDate", query = "Select distinct e from EmployeeEntity e JOIN e.skills s JOIN e.daysAvailable d where s in :skills AND d = :day")
})
@Entity
@Table(name = "employees")
public class EmployeeEntity extends PersonEntity {

	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Set<EmployeeSkill> skills;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
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
