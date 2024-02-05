package com.fpmislata.series.domain.service.impl;


import com.fpmislata.series.domain.entity.ActorVoz;
import com.fpmislata.series.domain.entity.Personaje;
import com.fpmislata.series.domain.entity.Serie;
import com.fpmislata.series.domain.repository.ActorVozRepository;
import com.fpmislata.series.domain.repository.PersonajeRepository;
import com.fpmislata.series.domain.repository.SerieRepository;
import com.fpmislata.series.domain.service.PersonajeService;
import com.fpmislata.series.mapper.PersonajeMapper;
import com.fpmislata.series.persistence.model.PersonajeEntity;
import com.fpmislata.series.persistence.model.SerieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.fpmislata.series.validation.Validation.validate;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private ActorVozRepository actorVozRepository;

    public List<Personaje> getAll() {
        return personajeRepository.getAll();
    }

    @Override
    public Personaje findById(int id) {
        return personajeRepository.findById(id);
    }

    @Override
    public Personaje addPersonaje(Personaje personaje, int serieId, List<Integer> actorVozIdList) {
        Serie serie = serieRepository.findById(serieId);
        List<ActorVoz> actorVozList = actorVozRepository.findAllById(actorVozIdList);
        personaje.setSerie(serie);
        personaje.setActorVozList(actorVozList);
        validate(personaje);
        return personajeRepository.addPersonaje(personaje);
    }

    @Override
    public Personaje updatePersonaje(int id, Personaje personaje, int serieId, List<Integer> actorVozIdList) {
        Serie serie = serieRepository.findById(serieId);
        List<ActorVoz> actorVozList = actorVozRepository.findAllById(actorVozIdList);
        personaje.setSerie(serie);
        personaje.setActorVozList(actorVozList);
        return personajeRepository.updatePersonaje(id, personaje);
    }

    @Override
    public void deletePersonaje(int id) {
        personajeRepository.deletePersonaje(id);
    }
}
