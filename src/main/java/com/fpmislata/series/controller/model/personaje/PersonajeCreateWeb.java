package com.fpmislata.series.controller.model.personaje;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PersonajeCreateWeb {
    private String name;
    private String rol;
    private String descripcion;
    private int serieId;
    private List<Integer> actorVozIdList;
}
