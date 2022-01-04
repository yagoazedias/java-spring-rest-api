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

    @JsonProperty("recursos")
    @OneToMany
    @JoinColumn(name="recurso_id")
    private List<Recurso> recursos;

    public Colecao() {}

    public Colecao(Integer id, String titulo, List<Recurso> recursos) {
        this.id = id;
        this.titulo = titulo;
        this.recursos = recursos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }
}
