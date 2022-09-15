package com.udacity.jdnd.course3.critter.schedule.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.jdnd.course3.critter.schedule.entities.ScheduleEntity;

@Repository
public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Long> {

}
