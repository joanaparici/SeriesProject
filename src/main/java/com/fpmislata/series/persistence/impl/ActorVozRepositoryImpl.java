package com.fpmislata.series.persistence.impl;

import com.fpmislata.series.domain.entity.ActorVoz;
import com.fpmislata.series.domain.repository.ActorVozRepository;
import com.fpmislata.series.mapper.ActorVozMapper;
import com.fpmislata.series.persistence.dao.ActorVozDAO;
import com.fpmislata.series.persistence.model.ActorVozEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ActorVozRepositoryImpl implements ActorVozRepository {

    @Autowired
    ActorVozDAO actorVozDAO;
    @Override
    public List<ActorVoz> findAllById(List<Integer> ids) {
        List<ActorVozEntity> actorVozEntities = actorVozDAO.findAllById(ids);

        // Se mapean las entidades a dominios/modelos
        return actorVozEntities.stream()
                .map(ActorVozMapper.mapper::toActorVoz)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<ActorVoz> findAllById(List<Integer> id) {
//        List<ActorVozEntity> actorVozEntityList = actorVozDAO.findAllById(id);
//        return ActorVozMapper.actorVozEntityListToActorVozList(actorVozEntityList);
//    }
}
