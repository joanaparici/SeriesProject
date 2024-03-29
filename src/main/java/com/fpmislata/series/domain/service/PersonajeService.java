package com.fpmislata.series.domain.service;

import com.fpmislata.series.domain.entity.Personaje;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonajeService {
    List<Personaje> getAll();

    Personaje findById(int id);

    Personaje addPersonaje(Personaje personaje, int serieId, List<Integer> actorVozIdList);

    Personaje updatePersonaje(int id, Personaje personaje, int serieId, List<Integer> actorVozIdList);

    void deletePersonaje(int id);
}

