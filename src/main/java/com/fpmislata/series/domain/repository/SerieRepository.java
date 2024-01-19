package com.fpmislata.series.domain.repository;

import com.fpmislata.series.domain.entity.Serie;

import java.util.List;

public interface SerieRepository {
    List<Serie> getAll();
}
