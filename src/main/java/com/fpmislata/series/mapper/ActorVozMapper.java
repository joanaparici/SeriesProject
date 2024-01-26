package com.fpmislata.series.mapper;

import com.fpmislata.series.domain.entity.ActorVoz;
import com.fpmislata.series.persistence.model.ActorVozEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorVozMapper {

    ActorVozMapper mapper = Mappers.getMapper(ActorVozMapper.class);

    ActorVoz toActorVoz(ActorVozEntity actorVozEntity);
    List<ActorVoz> toActorVozList(List<ActorVozEntity> actorVozEntityList);

    default List<ActorVoz> actorVozEntitiesToActorVozList(List<ActorVozEntity> actorVozEntities) {
        if (actorVozEntities == null) {
            return null;
        }
        List<ActorVoz> actorVozList = new ArrayList<>();
        for (ActorVozEntity actorVozEntity : actorVozEntities) {
            actorVozList.add(mapper.toActorVoz(actorVozEntity));
        }
        return actorVozList;
    }

}
