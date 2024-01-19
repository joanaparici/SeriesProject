package com.fpmislata.series.mapper;

import com.fpmislata.series.controller.model.personaje.PersonajeDetailWeb;
import com.fpmislata.series.controller.model.personaje.PersonajeListWeb;
import com.fpmislata.series.domain.entity.ActorVoz;
import com.fpmislata.series.domain.entity.Personaje;
import com.fpmislata.series.persistence.model.PersonajeEntity;
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

    //@Mapping(target = "actorVozList")
    PersonajeDetailWeb toPersonajeDetailWeb(Personaje personaje);

    @Mapping(target = "actorVozList", expression = "java(ActorVozMapper.mapper.toActorVozList(personajeEntity.getActorVozEntities()))")
    Personaje toPersonaje(PersonajeEntity personajeEntity);



    // Método de utilidad para mapear List<ActorVoz> a List<String>
    default List<String> mapActorVozListToNameList(List<ActorVoz> actorVozList) {
        if (actorVozList == null) {
            return null;
        }
        return actorVozList.stream()
                .map(ActorVoz::getName) // Asume que ActorVoz tiene un método getNombre
                .collect(Collectors.toList());
    }


}