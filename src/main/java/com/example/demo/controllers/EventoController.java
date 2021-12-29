package com.example.demo.controllers;

import com.example.demo.model.Evento;
import com.example.demo.repository.IEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/evento")
public class EventoController {

    @Autowired
    private IEventoRepository eventoRepository;

    @GetMapping
    public ResponseEntity<List<Evento>> getAllTodos() {
        List<Evento> eventos = eventoRepository.findAll();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }
    @PostMapping
    public Evento create(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }
}
