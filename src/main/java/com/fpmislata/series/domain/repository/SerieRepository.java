package com.fpmislata.series.domain.repository;

import com.fpmislata.series.domain.entity.Serie;
import com.fpmislata.series.persistence.model.SerieEntity;

import java.util.List;

public interface SerieRepository {
    List<Serie> getAll();

    Serie findById(int id);

}
