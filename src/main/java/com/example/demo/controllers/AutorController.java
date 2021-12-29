package com.example.demo.controllers;

import com.example.demo.model.Autor;
import com.example.demo.repository.IAutorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {

    @Autowired
    private IAutorRepository autorRepository;

    Logger logger = LoggerFactory.getLogger(AutorController.class);

    @GetMapping
    public ResponseEntity<List<Autor>> getAllTodos() {
        List<Autor> autores = autorRepository.findAll();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @PostMapping
    public Autor create(@RequestBody Autor autor) {
        try {
            return autorRepository.save(autor);
        } catch (Exception e) {
            logger.error(String.valueOf(e));
            return null;
        }
    }
}
