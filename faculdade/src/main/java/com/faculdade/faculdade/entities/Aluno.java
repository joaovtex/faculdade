package com.faculdade.faculdade.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity (name = "alunos")

public class Aluno implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "RA")
    int ra;

    @Column (name = "Nome")
    String nome;

    @Column (name = "Data de Cadastro")
    LocalDate dataCadastro;

    @Column (name = "Ativo")
    Boolean ativo;

    public Aluno() {
    }

    public Aluno (String nome, LocalDate dataCadastro,boolean ativo) {
        super();
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
    }

    public int getRa(Integer ra) {
        return this.ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ra=" + ra +
                ", nome='" + nome + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", ativo=" + ativo +
                '}';
    }
}
