package com.fpmislata.series.controller.model.personaje;

import com.fpmislata.series.controller.model.serie.SerieListWeb;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PersonajeUpdateWeb {

    private String name;
    private String rol;
    private String descripcion;
    private int serieId;
    private List<Integer> actorVozIdList;
}

