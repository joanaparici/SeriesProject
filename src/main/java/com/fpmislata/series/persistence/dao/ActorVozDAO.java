package com.fpmislata.series.persistence.dao;

import com.fpmislata.series.persistence.model.ActorVozEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActorVozDAO extends JpaRepository<ActorVozEntity, Integer>{

}
