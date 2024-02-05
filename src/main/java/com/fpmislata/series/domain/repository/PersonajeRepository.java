package com.fpmislata.series.domain.repository;

import com.fpmislata.series.domain.entity.Personaje;

import java.util.List;

public interface PersonajeRepository {

    List<Personaje> getAll();

    Personaje findById(int id);

    Personaje addPersonaje(Personaje personaje);

    Personaje updatePersonaje(int id, Personaje personaje);

    void deletePersonaje(int id);
}
