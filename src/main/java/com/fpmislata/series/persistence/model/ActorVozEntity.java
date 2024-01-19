package com.fpmislata.series.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "actoresdevoz")
@Data
@NoArgsConstructor
public class ActorVozEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ActorID")
    private int id;
    @Column(name = "NombreActor")
    private String name;
    @Column(name = "Nacionalidad")
    private String nacionalidad;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "personaje_actor",
            joinColumns = @JoinColumn(name = "actorID"),
            inverseJoinColumns = @JoinColumn(name = "personajeID")
    )
    private List<PersonajeEntity> personajeEntities;


}
