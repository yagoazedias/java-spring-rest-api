package com.example.demo.controllers;

import com.example.demo.helpers.ValidationError;
import com.example.demo.model.Colecao;
import com.example.demo.model.Curso;
import com.example.demo.model.Recurso;
import com.example.demo.repository.IColecaoRepository;
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

    @Autowired
    private IColecaoRepository colecaoRepository;


    @PostMapping("/colecao/{colecaoId}")
    public ResponseEntity<Recurso> createRecurso(@PathVariable (value = "colecaoId") int colecaoId,
                                 @RequestBody Recurso recurso) {
        Optional<Colecao> colecao = colecaoRepository.findById(colecaoId);
        if (colecao.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        recurso.setColecao(colecao.get());
        recursoRepository.save(recurso);
        return new ResponseEntity<>(recurso, HttpStatus.OK);
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
}


