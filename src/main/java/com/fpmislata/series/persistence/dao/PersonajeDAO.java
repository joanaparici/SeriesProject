package com.fpmislata.series.persistence.dao;

import com.fpmislata.series.persistence.model.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeDAO extends JpaRepository<PersonajeEntity, Integer> {
    List<PersonajeEntity> findAll();

}
