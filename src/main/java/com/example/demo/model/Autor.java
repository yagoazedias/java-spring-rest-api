package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue
    @JsonProperty
    private Integer id;

    @JsonProperty
    private String email;

    @Column(length=64)
    @JsonProperty
    private String nome;

    @Column(length=64)
    @JsonProperty
    private String sobrenome;

    @Column(length=256)
    @JsonProperty
    private String afiliacao;

    @JsonProperty
    private String Orcid;
}