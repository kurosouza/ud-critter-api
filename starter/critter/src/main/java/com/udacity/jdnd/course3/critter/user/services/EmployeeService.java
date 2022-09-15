package com.udacity.jdnd.course3.critter.user.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.jdnd.course3.critter.basictypes.EmployeeSkill;
import com.udacity.jdnd.course3.critter.exceptions.AppEntityNotFoundException;
import com.udacity.jdnd.course3.critter.user.entities.EmployeeEntity;
import com.udacity.jdnd.course3.critter.user.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@PersistenceContext
	private EntityManager entityManager;

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Transactional
	public EmployeeEntity createEmployee(EmployeeEntity employee) {
		EmployeeEntity saved = employeeRepository.save(employee);
		return saved;
	}
	
	public EmployeeEntity findEmployeeById(Long id) {
		EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(AppEntityNotFoundException::new);
		return employee;
	}
	
	@Transactional
	public EmployeeEntity setEmployeeAvailablity(Set<DayOfWeek> daysAvailable, Long employeeId) {
		EmployeeEntity employee = employeeRepository.findById(employeeId).orElseThrow(AppEntityNotFoundException::new);
		
		daysAvailable.forEach(dayOfWeek -> {
			if(!employee.getDaysAvailable().contains(dayOfWeek)) {
				employee.getDaysAvailable().add(dayOfWeek);
			}
		});
		
		return employee;
	}
	
	public List<EmployeeEntity> findEmployeesForService(LocalDate appointmentDate, Set<EmployeeSkill> skills) {
		TypedQuery<EmployeeEntity> employeeQuery = entityManager.createNamedQuery("Employee.FindEmployeesBySkillsAndDate", EmployeeEntity.class);
		employeeQuery.setParameter("skills", skills);
		employeeQuery.setParameter("day", appointmentDate.getDayOfWeek());
		List<EmployeeEntity> matchedEmployees = employeeQuery.getResultList();
		
		return matchedEmployees;
	}
}
