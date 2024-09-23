package com.faculdade.faculdade.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name = "pessoa")

public class Pessoa implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    int id;

    @Column (name = "nome")
    String nome;

    @Column (name = "cpf")
    String cpf;

    public Pessoa() {}

    public Pessoa(String nome, String cpf) {
        super();
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "ID=" + id +
                ", Nome='" + nome + '\'' +
                ", CPF='" + cpf + '\'' +
                '}';
    }
}
