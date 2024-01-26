package com.fpmislata.series.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Personaje {
    private int id;
    private String name;
    private String rol;
    private String descripcion;
    private List<ActorVoz> actorVozList;
    private Serie serie;
}
