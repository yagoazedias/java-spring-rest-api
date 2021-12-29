package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "colecoes")
@Inheritance(strategy= InheritanceType.JOINED)
public class Colecao {
    @Id
    @GeneratedValue
    @JsonProperty
    private Integer id;

    @Column(length=1024)
    @JsonProperty
    private String titulo;

    @OneToMany
    @JoinColumn(name="recurso_id")
    private List<Recurso> recursos;
}
