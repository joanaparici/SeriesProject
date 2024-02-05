package com.fpmislata.series.mapper;

import com.fpmislata.series.controller.model.serie.SerieListWeb;
import com.fpmislata.series.domain.entity.Serie;
import com.fpmislata.series.domain.repository.SerieRepository;
import com.fpmislata.series.persistence.model.SerieEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SerieMapper {
    SerieMapper mapper = Mappers.getMapper(SerieMapper.class);

    List<Serie> toSerieList(List<SerieEntity> serieEntities);

    SerieListWeb toSerieListWeb(Serie serie);

    Serie toSerie(SerieEntity serieEntity);


    default String serieEntityToSerie(SerieEntity serieEntity) {
        if (serieEntity == null) {
            return null;
        }
        return serieEntity.getTitle();
    }


    SerieEntity toSerieEntity(Serie serie);

}

