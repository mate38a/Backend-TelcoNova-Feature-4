package com.Fabrica.TelcoNova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fabrica.TelcoNova.model.GroupModel;

@Repository
public interface GroupRepository extends JpaRepository<GroupModel, Long> {}
