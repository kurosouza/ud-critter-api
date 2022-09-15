package com.udacity.jdnd.course3.critter.user.services;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.jdnd.course3.critter.exceptions.AppEntityNotFoundException;
import com.udacity.jdnd.course3.critter.pet.entities.PetEntity;
import com.udacity.jdnd.course3.critter.pet.repositories.PetRepository;
import com.udacity.jdnd.course3.critter.user.entities.CustomerEntity;
import com.udacity.jdnd.course3.critter.user.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private final CustomerRepository customerRepository;
	private final PetRepository petRepository;
	
	public CustomerService(CustomerRepository customerRepository, PetRepository petRepository) {
		super();
		this.customerRepository = customerRepository;
		this.petRepository = petRepository;
	}
	
	@Transactional
	public CustomerEntity createCustomer(CustomerEntity customer) {
		CustomerEntity result = customerRepository.save(customer);
		return result;
	}
	
	public Iterable<CustomerEntity> getCustomers() {
		Iterable<CustomerEntity> customers = customerRepository.findAll();
		return customers;
	}
	
	public CustomerEntity findCustomerByPet(PetEntity pet) throws AppEntityNotFoundException {
		TypedQuery<CustomerEntity> customerQuery = entityManager.createNamedQuery("Customer.findByPet", CustomerEntity.class);
		customerQuery.setParameter("pet", pet);
		
		CustomerEntity customer = customerQuery.getSingleResult();
		return customer;
	}

}
