package com.fpmislata.series.mapper;

import com.fpmislata.series.controller.model.personaje.PersonajeCreateWeb;
import com.fpmislata.series.controller.model.personaje.PersonajeDetailWeb;
import com.fpmislata.series.controller.model.personaje.PersonajeListWeb;
import com.fpmislata.series.controller.model.personaje.PersonajeUpdateWeb;
import com.fpmislata.series.domain.entity.ActorVoz;
import com.fpmislata.series.domain.entity.Personaje;
import com.fpmislata.series.domain.entity.Serie;
import com.fpmislata.series.domain.repository.SerieRepository;
import com.fpmislata.series.persistence.model.PersonajeEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PersonajeMapper {
    PersonajeMapper mapper = Mappers.getMapper(PersonajeMapper.class);

    List<Personaje> toPersonajeList(List<PersonajeEntity> personajeEntities);

    PersonajeListWeb toPersonajeListWeb(Personaje personaje);


    @Mapping(target = "serieList", expression = "java(com.fpmislata.series.mapper.SerieMapper.mapper.toSerieListWeb(personaje.getSerie()))")
    PersonajeDetailWeb toPersonajeDetailWeb(Personaje personaje);

    @Mapping(target = "actorVozList", expression = "java(com.fpmislata.series.mapper.ActorVozMapper.mapper.actorVozEntitiesToActorVozList(personajeEntity.getActorVozEntities()))")
    @Mapping(target = "serie", expression = "java(com.fpmislata.series.mapper.SerieMapper.mapper.toSerie(personajeEntity.getSerieEntity()))")
    Personaje toPersonaje(PersonajeEntity personajeEntity);

    // Método de utilidad para mapear List<ActorVoz> a List<String>
    default List<String> mapActorVozListToNameList(List<ActorVoz> actorVozList) {
        if (actorVozList == null) {
            return null;
        }
        return actorVozList.stream().map(ActorVoz::getName) // Asume que ActorVoz tiene un método getNombre
                .collect(Collectors.toList());
    }

    @Mapping(target = "serieEntity", expression = "java(com.fpmislata.series.mapper.SerieMapper.mapper.toSerieEntity(personaje.getSerie()))")
    @Mapping(target = "actorVozEntities", expression = "java(com.fpmislata.series.mapper.ActorVozMapper.mapper.actorVozListToActorVozEntityList(personaje.getActorVozList()))")
    PersonajeEntity toPersonajeEntity(Personaje personaje);

    // Método de utilidad para obtener Serie a partir de serieId
//    default Serie mapSerieIdToSerie(int serieId, @Context SerieRepository serieRepository) {
//        return serieRepository.findById(serieId);
//    }

    Personaje PersonajeCreateWebtoPersonaje(PersonajeCreateWeb personajeCreateWeb);

    Personaje PersonajeUpdateWebtoPersonaje(PersonajeUpdateWeb personajeUpdateWeb);
}
