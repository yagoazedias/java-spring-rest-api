package com.example.demo.controllers;

import com.example.demo.model.Recurso;
import com.example.demo.repository.IRecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recurso")
public class RecursosController {

    @Autowired
    private IRecursoRepository recursoRepository;

    @GetMapping
    public ResponseEntity<List<Recurso>> getAllTodos() {
        List<Recurso> recursos = recursoRepository.findAll();
        return new ResponseEntity<>(recursos, HttpStatus.OK);
    }

    @PostMapping
    public Recurso create(@RequestBody Recurso recurso) {
        return recursoRepository.save(recurso);
    }
}


