package com.fpmislata.series.controller;


import com.fpmislata.series.controller.model.serie.SerieListWeb;
import com.fpmislata.series.domain.entity.Serie;
import com.fpmislata.series.domain.service.SerieService;
import com.fpmislata.series.http_response.Response;
import com.fpmislata.series.mapper.SerieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(SerieController.SERIES)
@RestController
public class SerieController {

    public static final String SERIES = "/series";

    @Autowired
    private SerieService serieService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll() {
        List<Serie> series = serieService.getAll();
        List<SerieListWeb> seriesWeb = series.stream()
                .map(SerieMapper.mapper::toSerieListWeb)
                .toList();
        Response response = Response.builder()
                .data(seriesWeb)
                .build();
        return response;

    }

}
