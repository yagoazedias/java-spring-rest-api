package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "eventos")
@PrimaryKeyJoinColumn(name="id")
public class Evento extends Colecao {
    @Id
    @GeneratedValue
    private Integer id;
    private Date data_de_inicio;
    private Date data_de_fim;
}
