package com.example.demo.repository;

import com.example.demo.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecursoRepository extends JpaRepository<Recurso, Integer> {}
