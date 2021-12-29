package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="recursos")
public class Recurso {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length=1024)
    private String titulo;

    @Column(length=4096)
    @JsonProperty
    private String descricao;

    @JsonProperty
    private String link;

    @JsonProperty
    private String imagem;

    @JsonProperty
    private Date data_de_cricao;

    @JsonProperty
    private Date data_de_registro;

    @JsonProperty
    public ArrayList<String> palavras_chaves;

    @OneToMany
    @JoinColumn(name="autor_id")
    private List<Autor> autores;
}
