package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "colecoes")
@Inheritance(strategy= InheritanceType.JOINED)
public class Colecao {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length=1024)
    private String titulo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private List<Recurso> recursos = new ArrayList<Recurso>();
}
