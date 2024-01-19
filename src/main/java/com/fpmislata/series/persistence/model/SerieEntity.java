package com.fpmislata.series.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "series")
@Data
@NoArgsConstructor
public class SerieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SerieID")
    private int id;
    @Column(name = "Nombre")
    private String title;
    @Column(name = "Anyoinicio")
    private int startYear;
    @Column(name = "Anyofin")
    private Integer endYear;
    @Column(name = "Genero")
    private String genre;
    @Column(name = "Sinopsis")
    private String synopsis;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "serieID")
    private List<PersonajeEntity> personajeEntity;
}
