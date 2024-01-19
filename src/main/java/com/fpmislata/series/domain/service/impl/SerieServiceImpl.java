package com.fpmislata.series.domain.service.impl;

import com.fpmislata.series.domain.entity.Serie;
import com.fpmislata.series.domain.repository.SerieRepository;
import com.fpmislata.series.domain.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements SerieService {
    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> getAll() {
        return serieRepository.getAll();
    }

}
