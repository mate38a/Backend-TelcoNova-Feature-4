package com.Fabrica.TelcoNova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fabrica.TelcoNova.model.AlertModel;

@Repository
public interface AlertRepository extends JpaRepository<AlertModel, Long> {
    List<AlertModel> findByActive(Boolean active);
}

