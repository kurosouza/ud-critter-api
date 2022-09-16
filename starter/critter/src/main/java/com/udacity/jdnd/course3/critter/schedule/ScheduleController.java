package com.udacity.jdnd.course3.critter.schedule;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udacity.jdnd.course3.critter.mapper.Mapper;
import com.udacity.jdnd.course3.critter.schedule.entities.ScheduleEntity;
import com.udacity.jdnd.course3.critter.schedule.services.ScheduleService;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	private final ScheduleService scheduleService;
	private final Mapper mapper;
	
	public ScheduleController(ScheduleService scheduleService, Mapper mapper) {
		this.scheduleService = scheduleService;
		this.mapper = mapper;
	}

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        ScheduleEntity saved = scheduleService.createSchedule(scheduleDTO.getEmployeeIds(), scheduleDTO.getPetIds(), scheduleDTO.getActivities(), scheduleDTO.getDate());
        return mapper.toDTO(saved);
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<ScheduleEntity> schedules = scheduleService.getAllSchedules();
        List<ScheduleDTO> scheduleDtos = schedules.stream().map(mapper::toDTO).collect(Collectors.toList());
        return scheduleDtos;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        List<ScheduleEntity> schedules = scheduleService.getSchedulesForPet(petId);
        List<ScheduleDTO> scheduleDtos = schedules.stream().map(mapper::toDTO).collect(Collectors.toList());
        return scheduleDtos;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
    	 List<ScheduleEntity> schedules = scheduleService.getSchedulesForEmployee(employeeId);
         List<ScheduleDTO> scheduleDtos = schedules.stream().map(mapper::toDTO).collect(Collectors.toList());
         return scheduleDtos;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
    	 List<ScheduleEntity> schedules = scheduleService.getSchedulesForCustomer(customerId);
         List<ScheduleDTO> scheduleDtos = schedules.stream().map(mapper::toDTO).collect(Collectors.toList());
         return scheduleDtos;
    }
}
