package com.fpmislata.series.domain.service.impl;


import com.fpmislata.series.domain.entity.Personaje;
import com.fpmislata.series.domain.repository.PersonajeRepository;
import com.fpmislata.series.domain.service.PersonajeService;
import com.fpmislata.series.mapper.PersonajeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    public List<Personaje> getAll() {
        return personajeRepository.getAll();
    }

    @Override
    public Personaje findById(int id) {
        return personajeRepository.findById(id);
    }

    @Override
    public Personaje addPersonaje(Personaje personaje) {

        return personajeRepository.addPersonaje(personaje);
    }
}
