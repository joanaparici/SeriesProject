package com.fpmislata.series.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "personajes")
@Data
@NoArgsConstructor
public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonajeID")
    private int id;
    @Column(name = "NombrePersonaje")
    private String name;
    @Column(name = "Rol")
    private String rol;
    @Column(name = "Descripcion")
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SerieID")
    private SerieEntity serieEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "personaje_actor",
            joinColumns = @JoinColumn(name = "PersonajeID"),
            inverseJoinColumns = @JoinColumn(name = "ActorID")
    )
    private List<ActorVozEntity> actorVozEntities;
}
