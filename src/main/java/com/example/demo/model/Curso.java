package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cursos")
@PrimaryKeyJoinColumn(name="id")
public class Curso extends Colecao {
    @Id
    @GeneratedValue
    private Integer id;
    @JsonProperty
    private Date data_de_registro;
}