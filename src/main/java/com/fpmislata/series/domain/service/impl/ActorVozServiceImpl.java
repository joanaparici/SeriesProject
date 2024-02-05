package com.fpmislata.series.domain.service.impl;

import com.fpmislata.series.domain.entity.ActorVoz;
import com.fpmislata.series.domain.repository.ActorVozRepository;
import com.fpmislata.series.domain.service.ActorVozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorVozServiceImpl implements ActorVozService {

    @Autowired
    private ActorVozRepository actorVozRepository;


}
