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
    @Column(name = "SerieID")
    private int serieId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "personaje_actor",
        joinColumns = @JoinColumn(name = "personajeID"),
        inverseJoinColumns = @JoinColumn(name = "actorID")
    )
    private List<ActorVozEntity> actorVozEntities;
}
