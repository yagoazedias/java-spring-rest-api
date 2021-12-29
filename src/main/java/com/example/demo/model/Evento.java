package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eventos")
@PrimaryKeyJoinColumn(name="id")
public class Evento extends Colecao {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonProperty
    private Date data_de_inicio;

    @JsonProperty
    private Date data_de_fim;
}
