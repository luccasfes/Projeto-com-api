package com.senai.ProjetoFinalSpingboot.model;

import javax.persistence.*;

@Entity
@Table(name = "Curso")

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;
    @Column
    private String nome;

    public Curso(){

    }

    public Curso(Integer id){
        this.Id = id;

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
