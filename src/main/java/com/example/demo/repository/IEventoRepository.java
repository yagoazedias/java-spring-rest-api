package com.example.demo.repository;

import com.example.demo.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventoRepository extends JpaRepository<Evento, Integer> {}
