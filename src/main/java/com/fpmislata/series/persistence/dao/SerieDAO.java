package com.fpmislata.series.persistence.dao;

import com.fpmislata.series.domain.entity.Serie;
import com.fpmislata.series.persistence.model.SerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieDAO extends JpaRepository<SerieEntity, Integer> {
    List<SerieEntity> findAll();

    SerieEntity findById(int id);
}
