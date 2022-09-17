package com.udacity.jdnd.course3.critter.user.entities;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.udacity.jdnd.course3.critter.basictypes.EmployeeSkill;
import com.udacity.jdnd.course3.critter.schedule.entities.ScheduleEntity;


@NamedQueries({
//	@NamedQuery(name = "Employee.FindEmployeesBySkillsAndDate", query = "Select distinct e from EmployeeEntity e JOIN e.skills s JOIN e.daysAvailable d where s in :skills AND d in :day")
	@NamedQuery(name = "Employee.FindEmployeesBySkillsAndDate", query = "Select distinct e from EmployeeEntity e, IN (e.skills) s where s in (:skills) AND e.daysAvailable IN :day")
})
@Entity
@Table(name = "employees")
public class EmployeeEntity extends PersonEntity {
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Set<EmployeeSkill> skills = new HashSet<>();
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Set<DayOfWeek> daysAvailable = new HashSet<>();
	
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
