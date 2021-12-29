package com.example.demo.controllers;

import com.example.demo.model.Curso;
import com.example.demo.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/curso")
public class CursoController {

    @Autowired
    private ICursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<List<Curso>> getAllTodos() {
        List<Curso> cursos = cursoRepository.findAll();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @PostMapping
    public Curso create(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }
}
