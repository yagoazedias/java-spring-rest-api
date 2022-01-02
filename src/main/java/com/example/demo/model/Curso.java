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
    @JsonProperty("data_de_registro")
    private Date dataDeRegistro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(Date dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }
}