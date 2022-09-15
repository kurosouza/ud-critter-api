package com.udacity.jdnd.course3.critter.mapper;

import com.udacity.jdnd.course3.critter.pet.PetDTO;
import com.udacity.jdnd.course3.critter.pet.entities.PetEntity;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import com.udacity.jdnd.course3.critter.schedule.entities.ScheduleEntity;
import com.udacity.jdnd.course3.critter.user.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeDTO;
import com.udacity.jdnd.course3.critter.user.entities.CustomerEntity;
import com.udacity.jdnd.course3.critter.user.entities.EmployeeEntity;


public interface Mapper {
	
	// Customer
	CustomerDTO toDTO(CustomerEntity customer);
	CustomerEntity toEntity(CustomerDTO customerDTO);
	
	// Employee
	EmployeeDTO toDTO(EmployeeEntity employee);
	EmployeeEntity toEntity(EmployeeDTO employeeDTO);
	
	// Schedule
	ScheduleDTO toDTO(ScheduleEntity schedule);
	ScheduleEntity toEntity(ScheduleDTO scheduleDTO);

	// Pet
	PetDTO toDTO(PetEntity pet);
	PetEntity toEntity(PetDTO petDTO);
}
