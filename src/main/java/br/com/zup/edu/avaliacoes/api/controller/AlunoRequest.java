package br.com.zup.edu.avaliacoes.api.controller;

import br.com.zup.edu.avaliacoes.api.model.Aluno;

import javax.validation.constraints.NotBlank;

public class AlunoRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String bootcamp;

    public AlunoRequest(String nome, String email, String bootcamp) {
        this.nome = nome;
        this.email = email;
        this.bootcamp = bootcamp;
    }

    public AlunoRequest() {
    }

    public Aluno paraAluno() {
        return new Aluno(nome,email,bootcamp);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getBootcamp() {
        return bootcamp;
    }
}
