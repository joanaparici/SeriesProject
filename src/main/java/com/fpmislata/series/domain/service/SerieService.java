package com.fpmislata.series.domain.service;

import com.fpmislata.series.domain.entity.Serie;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SerieService {
    List<Serie> getAll();
}
