package com.fpmislata.series.persistence.impl;

import com.fpmislata.series.domain.entity.Serie;
import com.fpmislata.series.domain.repository.SerieRepository;
import com.fpmislata.series.mapper.SerieMapper;
import com.fpmislata.series.persistence.dao.SerieDAO;
import com.fpmislata.series.persistence.model.SerieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SerieRepositoryImpl implements SerieRepository {

    @Autowired
    SerieDAO serieDAO;
    @Override
    public List<Serie> getAll() {
        List<SerieEntity> serieEntities;
//        return serieDAO.getAll().stream().toList();
        serieEntities = serieDAO.findAll();
        return SerieMapper.mapper.toSerieList(serieEntities);
    }

    @Override
    public Serie findById(int id) {
        SerieEntity serieEntity;
        serieEntity = serieDAO.findById(id);
        return SerieMapper.mapper.toSerie(serieEntity);
    }
}
