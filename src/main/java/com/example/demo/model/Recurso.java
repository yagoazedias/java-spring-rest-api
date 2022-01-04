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
    @JsonProperty("dataDeCricao")
    private Date dataDeCricao;
    @JsonProperty("data_de_registro")
    private Date dataDeRegistro;
    @JsonProperty("palavras_chaves")
    public ArrayList<String> palavrasChaves;
    @OneToMany
    @JoinColumn(name="autor_id")
    private List<Autor> autores;
    @JsonProperty("colecao_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="colecao_id")
    private Colecao colecao;

    public Recurso() {}

    public Recurso(Integer id, String titulo, String descricao, String link, String imagem, Date dataDeCricao, Date dataDeRegistro, ArrayList<String> palavrasChaves, List<Autor> autores) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.link = link;
        this.imagem = imagem;
        this.dataDeCricao = dataDeCricao;
        this.dataDeRegistro = dataDeRegistro;
        this.palavrasChaves = palavrasChaves;
        this.autores = autores;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Date getDataDeCricao() {
        return dataDeCricao;
    }

    public void setDataDeCricao(Date dataDeCricao) {
        this.dataDeCricao = dataDeCricao;
    }

    public Date getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(Date dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    public ArrayList<String> getPalavrasChaves() {
        return palavrasChaves;
    }

    public void setPalavrasChaves(ArrayList<String> palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
