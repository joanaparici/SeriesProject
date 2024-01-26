package com.fpmislata.series.controller.model.personaje;

import com.fpmislata.series.controller.model.serie.SerieListWeb;
import com.fpmislata.series.domain.entity.Serie;
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
    private SerieListWeb serieList;
    private List<String> actorVozList;
}
