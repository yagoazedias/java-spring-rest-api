package com.example.demo.model;

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
    private String descricao;
    private String link;
    private String imagem;

    private Date data_de_cricao;

    private Date data_de_registro;
    public ArrayList<String> palavras_chaves;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private List<Autor> recursos = new ArrayList<Autor>();
}
