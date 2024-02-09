package com.fpmislata.series.domain.entity;

import com.fpmislata.series.validation.DescriptionLenght;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Personaje {
    private int id;

    @NotBlank(message = "Tienes que poner un nombre")
    private String name;

    @NotBlank(message = "Tienes que poner un rol")
    private String rol;

    @Nullable
    @DescriptionLenght
    private String descripcion;

    @Size(min = 1, message = "Debes insertar mínimo un actor de voz")
    private List<ActorVoz> actorVozList;
    private Serie serie;
}
