package com.udacity.jdnd.course3.critter.pet;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udacity.jdnd.course3.critter.mapper.Mapper;
import com.udacity.jdnd.course3.critter.pet.entities.PetEntity;
import com.udacity.jdnd.course3.critter.pet.services.PetService;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
	
	private final PetService petService;
	private final Mapper mapper;
	
    public PetController(PetService petService, Mapper mapper) {
		this.petService = petService;
		this.mapper = mapper;
	}

	@PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        PetEntity pet = mapper.toEntity(petDTO);
        PetEntity saved = petService.savePet(petDTO.getOwnerId(), pet);
        
        return mapper.toDTO(saved);
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        PetEntity pet = petService.findPetById(petId);
        return mapper.toDTO(pet);
    }

    @GetMapping
    public List<PetDTO> getPets(){
        List<PetEntity> pets = petService.findAllPets();
        List<PetDTO> petDTOs = pets.stream().map(mapper::toDTO).collect(Collectors.toList());
        return petDTOs;
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<PetEntity> pets = petService.findPetsByOwner(ownerId);
        List<PetDTO> petDtos = pets.stream().map(mapper::toDTO).collect(Collectors.toList());
        
        return petDtos;
    }
}
