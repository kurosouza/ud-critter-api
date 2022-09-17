package com.udacity.jdnd.course3.critter.user.repositories;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.basictypes.EmployeeSkill;
import com.udacity.jdnd.course3.critter.user.entities.EmployeeEntity;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {

//	List<EmployeeEntity> findAllEmployeeEntityBySkillsAndDaysAvailable(Set<EmployeeSkill> skills, Set<DayOfWeek> days);
}
