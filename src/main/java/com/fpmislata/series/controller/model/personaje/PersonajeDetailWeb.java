package com.fpmislata.series.controller.model.personaje;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PersonajeDetailWeb {
    private String name;
    private String rol;
    private String descripcion;
    private List<String> actorVozList;
}
