package com.fpmislata.series.persistence.impl;

import com.fpmislata.series.domain.entity.Personaje;
import com.fpmislata.series.domain.repository.PersonajeRepository;
import com.fpmislata.series.mapper.PersonajeMapper;
import com.fpmislata.series.persistence.dao.PersonajeDAO;
import com.fpmislata.series.persistence.model.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository {

    @Autowired
    PersonajeDAO personajeDAO;

    @Override
    public List<Personaje> getAll() {
        List<PersonajeEntity> personajeEntities;
        personajeEntities = personajeDAO.findAll();
        return PersonajeMapper.mapper.toPersonajeList(personajeEntities);
    }

    @Override
    public Optional<Personaje> findById(int id) {
        return Optional.ofNullable(PersonajeMapper.mapper.toPersonaje(personajeDAO.findById(id).orElse(null)));
    }

    @Override
    @Transactional
    public Personaje addPersonaje(Personaje personaje) {
        PersonajeEntity personajeEntity = PersonajeMapper.mapper.toPersonajeEntity(personaje);      // Convertimos el personaje a personajeEntity
        personajeDAO.save(personajeEntity);                                                         // Guardamos el personajeEntity en la base de datos
        return PersonajeMapper.mapper.toPersonaje(personajeEntity);                                 // Devolvemos el personaje con el id
    }

    @Override
    public Personaje updatePersonaje(int id, Personaje personaje) {
        PersonajeEntity personajeEntity = PersonajeMapper.mapper.toPersonajeEntity(personaje);      // Convertimos el personaje a personajeEntity
        personajeEntity.setId(id);                                                                  // Le asignamos el id
        personajeDAO.save(personajeEntity);                                                         // Guardamos el personajeEntity en la base de datos
        return PersonajeMapper.mapper.toPersonaje(personajeEntity);                                 // Devolvemos el personaje con el id
    }

    @Override
    public void deletePersonaje(int id) {
        personajeDAO.deleteById(id);
    }
}
