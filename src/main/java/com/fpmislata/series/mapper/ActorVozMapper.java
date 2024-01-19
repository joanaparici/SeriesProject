package com.fpmislata.series.mapper;

import com.fpmislata.series.domain.entity.ActorVoz;
import com.fpmislata.series.persistence.model.ActorVozEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorVozMapper {

    ActorVozMapper mapper = Mappers.getMapper(ActorVozMapper.class);

    ActorVoz toActorVoz(ActorVozEntity actorVozEntity);
    List<ActorVoz> toActorVozList(List<ActorVozEntity> actorVozEntityList);
}
