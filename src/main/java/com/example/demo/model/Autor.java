package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue
    private Integer id;
    private String email;

    @Column(length=64)
    private String nome;

    @Column(length=64)
    private String sobrenome;

    @Column(length=256)
    private String afiliacao;
    private String Orcid;
}