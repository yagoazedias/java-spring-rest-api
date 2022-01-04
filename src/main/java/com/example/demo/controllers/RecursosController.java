package com.example.demo.controllers;

import com.example.demo.helpers.ValidationError;
import com.example.demo.model.Curso;
import com.example.demo.model.Recurso;
import com.example.demo.repository.IRecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Recurso> getRecursoById(@PathVariable int id) {
        Optional<Recurso> recurso = recursoRepository.findById(id);
        if (!recurso.isEmpty()) {
            return new ResponseEntity<>(recurso.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recurso> deleteRecursoById(@PathVariable int id) {
        Optional<Recurso> recurso = recursoRepository.findById(id);
        if (!recurso.isEmpty()) {
            recursoRepository.deleteById(id);
            return new ResponseEntity<>(recurso.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recurso> updateRecursoById(@PathVariable int id, @RequestBody Recurso incomingRecurso) {
        Optional<Recurso> recurso = recursoRepository.findById(id);
        if (!recurso.isEmpty()) {
            if (!Objects.equals(incomingRecurso.getId(), recurso.get().getId()))
                return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

            recursoRepository.save(incomingRecurso);
            return new ResponseEntity<>(incomingRecurso, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public Recurso create(@RequestBody Recurso recurso) {
        return recursoRepository.save(recurso);
    }
}


