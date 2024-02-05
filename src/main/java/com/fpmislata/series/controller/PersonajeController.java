package com.fpmislata.series.controller;

import com.fpmislata.series.controller.model.personaje.PersonajeCreateWeb;
import com.fpmislata.series.controller.model.personaje.PersonajeDetailWeb;
import com.fpmislata.series.controller.model.personaje.PersonajeListWeb;
import com.fpmislata.series.controller.model.personaje.PersonajeUpdateWeb;
import com.fpmislata.series.domain.entity.Personaje;
import com.fpmislata.series.domain.repository.SerieRepository;
import com.fpmislata.series.domain.service.PersonajeService;
import com.fpmislata.series.http_response.Response;
import com.fpmislata.series.mapper.PersonajeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(PersonajeController.PERSONAJES)
@RestController
public class PersonajeController {

    public static final String PERSONAJES = "/personajes";

    @Autowired
    private PersonajeService personajeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll(){
        List<Personaje> personajes = personajeService.getAll();
        List<PersonajeListWeb> personajesWeb = personajes.stream()
                .map(PersonajeMapper.mapper::toPersonajeListWeb)
                .toList();

        Response response = Response.builder()
                .data(personajesWeb)
                .build();
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response getPersonaje(@PathVariable("id") int id){
        Personaje personaje = personajeService.findById(id);
        PersonajeDetailWeb personajeWeb = PersonajeMapper.mapper.toPersonajeDetailWeb(personaje);
        Response response = Response.builder()
                .data(personajeWeb)
                .build();
        return response;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response addPersonaje(@RequestBody PersonajeCreateWeb personajeCreateWeb){
        Personaje personaje = PersonajeMapper.mapper.PersonajeCreateWebtoPersonaje(personajeCreateWeb);

        personajeService.addPersonaje(personaje, personajeCreateWeb.getSerieId(), personajeCreateWeb.getActorVozIdList());

        PersonajeDetailWeb personajeWeb = PersonajeMapper.mapper.toPersonajeDetailWeb(personaje);

        Response response = Response.builder()
                .data(personajeWeb)
                .data(personajeCreateWeb)
                .build();
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response updatePersonaje(@PathVariable("id") int id, @RequestBody PersonajeUpdateWeb personajeUpdateWeb){
        Personaje personaje = PersonajeMapper.mapper.PersonajeUpdateWebtoPersonaje(personajeUpdateWeb);
        personajeService.updatePersonaje(id, personaje, personajeUpdateWeb.getSerieId(), personajeUpdateWeb.getActorVozIdList());
        PersonajeDetailWeb personajeWeb = PersonajeMapper.mapper.toPersonajeDetailWeb(personaje);
        Response response = Response.builder()
                .data(personajeWeb)
                .data(personajeUpdateWeb)
                .build();
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public Response deletePersonaje(@PathVariable("id") int id){
        personajeService.deletePersonaje(id);
        Response response = Response.builder()
                .data("Personaje eliminado con id: " + id)
                .build();
        return response;
    }
}
