package com.fpmislata.series.controller;

import com.fpmislata.series.controller.model.personaje.PersonajeDetailWeb;
import com.fpmislata.series.controller.model.personaje.PersonajeListWeb;
import com.fpmislata.series.domain.entity.Personaje;
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

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("")
//    public Response addPersonaje(@RequestBody Personaje personaje){
//        Personaje personajeAdd = personajeService.addPersonaje(personaje);
//        PersonajeDetailWeb personajeWeb = PersonajeMapper.mapper.toPersonajeDetailWeb(personajeAdd);
//        Response response = Response.builder()
//                .data(personajeWeb)
//                .build();
//        return response;
//    }
//
//    @ResponseStatus(HttpStatus.OK)
//    @PutMapping("/{id}")
//    public Response updatePersonaje(@PathVariable("id") int id, @RequestBody Personaje personaje){
//        Personaje personajeUpdate = personajeService.updatePersonaje(id, personaje);
//        PersonajeDetailWeb personajeWeb = PersonajeMapper.mapper.toPersonajeDetailWeb(personajeUpdate);
//        Response response = Response.builder()
//                .data(personajeWeb)
//                .build();
//        return response;
//    }
}
