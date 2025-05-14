package com.Fabrica.TelcoNova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fabrica.TelcoNova.model.EventModel;

@Repository
public interface EventRepository extends JpaRepository<EventModel, Long>  {

}
