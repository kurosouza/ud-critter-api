package com.udacity.jdnd.course3.critter.pet.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.pet.entities.PetEntity;

@Repository
public interface PetRepository extends CrudRepository<PetEntity, Long> {

}
