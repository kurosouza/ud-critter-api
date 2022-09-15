package com.udacity.jdnd.course3.critter.user;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udacity.jdnd.course3.critter.mapper.Mapper;
import com.udacity.jdnd.course3.critter.pet.entities.PetEntity;
import com.udacity.jdnd.course3.critter.user.entities.CustomerEntity;
import com.udacity.jdnd.course3.critter.user.entities.EmployeeEntity;
import com.udacity.jdnd.course3.critter.user.services.CustomerService;
import com.udacity.jdnd.course3.critter.user.services.EmployeeService;

/**
 * Handles web requests related to Users.
 *
 * Includes requests for both customers and employees. Splitting this into
 * separate user and customer controllers would be fine too, though that is not
 * part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private CustomerService customerService;
	private EmployeeService employeeService;

	private Mapper mapper;

	public UserController(CustomerService customerService, EmployeeService employeeService, Mapper mapper) {
		this.customerService = customerService;
		this.employeeService = employeeService;
		this.mapper = mapper;		
	}

	@PostMapping("/customer")
	public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
		CustomerEntity customer = mapper.toEntity(customerDTO);
		CustomerEntity saved = customerService.createCustomer(customer);
		return mapper.toDTO(saved);
	}

	@GetMapping("/customer")
	public List<CustomerDTO> getAllCustomers() {
		Iterable<CustomerEntity> customers = customerService.getCustomers();

		List<CustomerDTO> customerDTO1 = StreamSupport.stream(customers.spliterator(), false).map(c -> {
			return mapper.toDTO(c);
		}).collect(Collectors.toList());

		return customerDTO1;
	}

	@GetMapping("/customer/pet/{petId}")
	public CustomerDTO getOwnerByPet(@PathVariable long petId) {
		PetEntity pet = new PetEntity();
		pet.setId(petId);
		CustomerEntity customer = customerService.findCustomerByPet(pet);

		return mapper.toDTO(customer);
	}

	@PostMapping("/employee")
	public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		EmployeeEntity saved = employeeService.createEmployee(mapper.toEntity(employeeDTO));
		return mapper.toDTO(saved);
	}

	@PostMapping("/employee/{employeeId}")
	public EmployeeDTO getEmployee(@PathVariable long employeeId) {
		EmployeeEntity result = employeeService.findEmployeeById(employeeId);
		return mapper.toDTO(result);
	}

	@PutMapping("/employee/{employeeId}")
	public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
		EmployeeEntity saved = employeeService.setEmployeeAvailablity(daysAvailable, employeeId);		
	}

	@GetMapping("/employee/availability")
	public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
		List<EmployeeEntity> matchedEmployees = employeeService.findEmployeesForService(employeeDTO.getDate(), employeeDTO.getSkills());
		List<EmployeeDTO> matchedEmployeeDto = matchedEmployees.stream().map(mapper::toDTO).collect(Collectors.toList());
		return matchedEmployeeDto;
	}

}
