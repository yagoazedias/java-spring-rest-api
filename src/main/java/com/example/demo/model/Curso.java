package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cursos")
@PrimaryKeyJoinColumn(name="id")
public class Curso extends Colecao {
    @Id
    @GeneratedValue
    private Integer id;
    private Date data_de_registro;
}