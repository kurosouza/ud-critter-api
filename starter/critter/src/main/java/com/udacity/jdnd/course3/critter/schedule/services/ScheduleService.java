package com.udacity.jdnd.course3.critter.schedule.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.util.StreamUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.jdnd.course3.critter.basictypes.EmployeeSkill;
import com.udacity.jdnd.course3.critter.exceptions.AppEntityNotFoundException;
import com.udacity.jdnd.course3.critter.pet.entities.PetEntity;
import com.udacity.jdnd.course3.critter.pet.repositories.PetRepository;
import com.udacity.jdnd.course3.critter.schedule.entities.ScheduleEntity;
import com.udacity.jdnd.course3.critter.schedule.repositories.ScheduleRepository;
import com.udacity.jdnd.course3.critter.user.entities.EmployeeEntity;
import com.udacity.jdnd.course3.critter.user.repositories.CustomerRepository;
import com.udacity.jdnd.course3.critter.user.repositories.EmployeeRepository;

@Service
public class ScheduleService {

	private final ScheduleRepository scheduleRepository;
	private final PetRepository petRepository;
	private final CustomerRepository customerRepository;
	private final EmployeeRepository employeeRepository;

	public ScheduleService(ScheduleRepository scheduleRepository, PetRepository petRepository,
			CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
		this.scheduleRepository = scheduleRepository;
		this.petRepository = petRepository;
		this.customerRepository = customerRepository;
		this.employeeRepository = employeeRepository;
	}
	
	@Transactional
	public ScheduleEntity createSchedule(List<Long> employeeIds, List<Long> petIds, Set<EmployeeSkill> activities, LocalDate date) {
		ScheduleEntity schedule = new ScheduleEntity();
		schedule.setDate(date);
		
		List<EmployeeEntity> employeeCollection = new ArrayList<EmployeeEntity>();
		employeeIds.forEach(empId -> {
			EmployeeEntity employee = employeeRepository.findById(empId).orElseThrow(AppEntityNotFoundException::new);
			employeeCollection.add(employee);
		});
		
		schedule.setEmployees(employeeCollection);
		
		List<PetEntity> petsCollection = new ArrayList<PetEntity>();
		petIds.forEach(petId -> {
			PetEntity pet = petRepository.findById(petId).orElseThrow(AppEntityNotFoundException::new);
			petsCollection.add(pet);
		});
		
		schedule.setPets(petsCollection);
		
		Set activitiesCollection = Set.copyOf(activities);
		schedule.setActivities(activitiesCollection);
		
		ScheduleEntity saved = scheduleRepository.save(schedule);
		
		return saved;
	}
	
	public List<ScheduleEntity> getAllSchedules() {
		List<ScheduleEntity> schedules = StreamUtils.createStreamFromIterator(scheduleRepository.findAll().iterator()).collect(Collectors.toList());
		return schedules;		
	}
	
	
	public List<ScheduleEntity> getSchedulesForPet(Long petId) {
		List<ScheduleEntity> scheduleCollection  = scheduleRepository.findAllScheduleEntityByPetsId(petId);
		return scheduleCollection;
	}
	
	public List<ScheduleEntity> getSchedulesForEmployee(Long employeeId) {
		List<ScheduleEntity> scheduleCollection  = scheduleRepository.findAllScheduleEntityByEmployeesId(employeeId);
		return scheduleCollection;
	}
	
	public List<ScheduleEntity> getSchedulesForCustomer(Long customerId) {
		List<ScheduleEntity> scheduleCollection  = scheduleRepository.findAllScheduleEntityByPetsOwnerId(customerId);
		return scheduleCollection;
	}
	
}
