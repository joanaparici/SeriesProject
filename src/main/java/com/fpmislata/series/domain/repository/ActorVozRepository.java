package com.fpmislata.series.domain.repository;

import com.fpmislata.series.domain.entity.ActorVoz;

import java.util.List;

public interface ActorVozRepository {
    List<ActorVoz> findAllById(List<Integer> id);
}
