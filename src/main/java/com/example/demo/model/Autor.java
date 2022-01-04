package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="recurso_id")
    private Recurso recurso;

    public Autor(Integer id, String email, String nome, String sobrenome, String afiliacao, String orcid, Recurso recurso) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.afiliacao = afiliacao;
        Orcid = orcid;
        this.recurso = recurso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getAfiliacao() {
        return afiliacao;
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    public String getOrcid() {
        return Orcid;
    }

    public void setOrcid(String orcid) {
        Orcid = orcid;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
}