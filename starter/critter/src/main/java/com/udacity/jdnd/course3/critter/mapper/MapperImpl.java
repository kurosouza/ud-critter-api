package com.udacity.jdnd.course3.critter.mapper;

import org.springframework.beans.BeanUtils;

import com.udacity.jdnd.course3.critter.pet.PetDTO;
import com.udacity.jdnd.course3.critter.pet.entities.PetEntity;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import com.udacity.jdnd.course3.critter.schedule.entities.ScheduleEntity;
import com.udacity.jdnd.course3.critter.user.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.EmployeeDTO;
import com.udacity.jdnd.course3.critter.user.entities.CustomerEntity;
import com.udacity.jdnd.course3.critter.user.entities.EmployeeEntity;

public class MapperImpl implements Mapper {

//	Customer
	
	@Override
	public CustomerDTO toDTO(CustomerEntity customer) {
		
		CustomerDTO customerDTO = new CustomerDTO();
		BeanUtils.copyProperties(customer, customerDTO);
		
		return customerDTO;
	}

	@Override
	public CustomerEntity toEntity(CustomerDTO customerDTO) {
		CustomerEntity customer = new CustomerEntity();
		BeanUtils.copyProperties(customerDTO, customer);
		
		return customer;
	}

	@Override
	public EmployeeDTO toDTO(EmployeeEntity employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employee, employeeDTO);
		return employeeDTO;
	}

	@Override
	public EmployeeEntity toEntity(EmployeeDTO employeeDTO) {
		EmployeeEntity employee = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDTO, employee);
		return employee;
	}

	@Override
	public ScheduleDTO toDTO(ScheduleEntity schedule) {
		ScheduleDTO scheduleDTO = new ScheduleDTO();
		BeanUtils.copyProperties(schedule, scheduleDTO);
		return scheduleDTO;
	}

	@Override
	public ScheduleEntity toEntity(ScheduleDTO scheduleDTO) {
		ScheduleEntity schedule = new ScheduleEntity();
		BeanUtils.copyProperties(scheduleDTO, schedule);
		return schedule;
	}

	@Override
	public PetDTO toDTO(PetEntity pet) {
		PetDTO petDTO = new PetDTO();
		BeanUtils.copyProperties(pet, petDTO);
		return petDTO;
	}

	@Override
	public PetEntity toEntity(PetDTO petDTO) {
		PetEntity pet = new PetEntity();
		BeanUtils.copyProperties(petDTO, pet);
		return pet;
	}

}
