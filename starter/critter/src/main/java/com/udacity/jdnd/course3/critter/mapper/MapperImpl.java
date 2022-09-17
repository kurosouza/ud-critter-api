package com.udacity.jdnd.course3.critter.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
		
		List<Long> petIds = new ArrayList<Long>();
		customer.getPets().forEach(pet -> petIds.add(pet.getId()));
		customerDTO.setPetIds(petIds);
		
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
		List<Long> employeeIds = schedule.getEmployees().stream().map(EmployeeEntity::getId).collect(Collectors.toList());
		scheduleDTO.setEmployeeIds(employeeIds);
		List<Long> petIds = schedule.getPets().stream().map(PetEntity::getId).collect(Collectors.toList());
		scheduleDTO.setPetIds(petIds);
		scheduleDTO.setActivities(Set.copyOf(schedule.getActivities()));
		scheduleDTO.setDate(schedule.getDate());
		scheduleDTO.setId(schedule.getId());
			
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
		petDTO.setType(pet.getPetType());
		if (pet.getOwner() != null) {
			petDTO.setOwnerId(pet.getOwner().getId());
		}
		return petDTO;
	}

	@Override
	public PetEntity toEntity(PetDTO petDTO) {
		PetEntity pet = new PetEntity();
		pet.setPetType(petDTO.getType());
		BeanUtils.copyProperties(petDTO, pet);
		return pet;
	}

}
