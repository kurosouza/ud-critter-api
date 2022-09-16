package com.udacity.jdnd.course3.critter.schedule.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.schedule.entities.ScheduleEntity;

@Repository
public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Long> {

	List<ScheduleEntity> findAllScheduleEntityByPetsId(Long petId);
	
	List<ScheduleEntity> findAllScheduleEntityByEmployeesId(Long employeeId);
	
	List<ScheduleEntity> findAllScheduleEntityByPetsOwnerId(Long customerId);
	
}
