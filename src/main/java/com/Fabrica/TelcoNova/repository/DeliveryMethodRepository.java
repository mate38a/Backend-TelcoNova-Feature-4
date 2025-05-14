package com.Fabrica.TelcoNova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fabrica.TelcoNova.model.DeliveryMethodModel;

@Repository
public interface DeliveryMethodRepository extends  JpaRepository<DeliveryMethodModel, Long>{

}
