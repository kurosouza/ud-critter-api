package com.udacity.jdnd.course3.critter.pet.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.util.StreamUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udacity.jdnd.course3.critter.exceptions.AppEntityNotFoundException;
import com.udacity.jdnd.course3.critter.pet.entities.PetEntity;
import com.udacity.jdnd.course3.critter.pet.repositories.PetRepository;
import com.udacity.jdnd.course3.critter.user.entities.CustomerEntity;
import com.udacity.jdnd.course3.critter.user.repositories.CustomerRepository;

@Service
public class PetService {

	private final PetRepository petRepository;
	private final CustomerRepository customerRepository;
	
	public PetService(PetRepository petRepository, CustomerRepository customerRepository) {	
		this.petRepository = petRepository;
		this.customerRepository = customerRepository;
	}
	
	@Transactional
	public PetEntity savePet(Long ownerId, PetEntity pet) {		
		CustomerEntity customer = customerRepository.findById(ownerId).orElseThrow(() -> new AppEntityNotFoundException("Could not find pet owner."));
		pet.setOwner(customer);
		PetEntity saved = petRepository.save(pet);
		customer.getPets().add(saved);
		customerRepository.save(customer);
		return saved;
	}
	
	public PetEntity findPetById(Long id) {
		PetEntity pet = petRepository.findById(id).orElseThrow(AppEntityNotFoundException::new);
		return pet;
	}
	
	public List<PetEntity> findAllPets() {
		Iterable<PetEntity> petsIterable = petRepository.findAll();
		
		List<PetEntity> pets = StreamUtils.createStreamFromIterator(petsIterable.iterator()).collect(Collectors.toList());
		return pets;
	}
	
	public List<PetEntity> findPetsByOwner(Long ownerId) {
		List<PetEntity> pets = petRepository.findAllByOwnerId(ownerId);
		return pets;		
	}
	
}
