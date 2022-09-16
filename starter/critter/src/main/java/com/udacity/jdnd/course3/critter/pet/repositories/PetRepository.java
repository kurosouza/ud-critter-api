package com.udacity.jdnd.course3.critter.pet.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.pet.entities.PetEntity;

@Repository
public interface PetRepository extends CrudRepository<PetEntity, Long> {

	@Query("Select p from PetEntity p where p.owner.id = :ownerId")
	List<PetEntity> findAllByOwnerId(@Param("ownerId") Long ownerId);
}
