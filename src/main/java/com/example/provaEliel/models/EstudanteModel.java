package com.example.provaEliel.models;

import com.example.provaEliel.enums.EstudanteEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_aluno")
public class EstudanteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    private String email;
    @Column(name = "age")
    private int idade;
    private EstudanteEnum aprovacao;

    public EstudanteModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }


    public String getEmail() {
        return email;
    }


    public int getIdade() {
        return idade;
    }

    public EstudanteEnum getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(EstudanteEnum aprovacao) {
        this.aprovacao = aprovacao;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
