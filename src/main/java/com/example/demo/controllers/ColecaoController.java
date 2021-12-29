package com.example.demo.controllers;

import com.example.demo.model.Colecao;
import com.example.demo.repository.IColecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/colecao")
public class ColecaoController {

    @Autowired
    private IColecaoRepository colecaoRepository;

    @GetMapping
    public ResponseEntity<List<Colecao>> getAllTodos() {
        List<Colecao> colecoes = colecaoRepository.findAll();
        return new ResponseEntity<>(colecoes, HttpStatus.OK);
    }

    @PostMapping
    public Colecao create(@RequestBody Colecao colecao) {
        return colecaoRepository.save(colecao);
    }
}
