package com.av3poo3.av3poo3.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="nome")
    private static String nome;
    
    @Column(name="matricula")
    private String matricula;

    @Column(name="email")
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

   
    @ManyToOne
    @JoinColumn(name = "turma_id") 
    private Turma turma;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Nota> notas;

    public static String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
