package com.fpmislata.series.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Serie {
    private int id;
    private String title;
    private int startYear;
    private int endYear;
    private String genre;
    private String synopsis;
}

