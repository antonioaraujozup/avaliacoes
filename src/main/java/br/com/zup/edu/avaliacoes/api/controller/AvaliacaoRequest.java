package br.com.zup.edu.avaliacoes.api.controller;

import br.com.zup.edu.avaliacoes.api.model.Aluno;
import br.com.zup.edu.avaliacoes.api.model.Avaliacao;

import javax.validation.constraints.NotBlank;

public class AvaliacaoRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String atividade;

    public AvaliacaoRequest(String titulo, String atividade) {
        this.titulo = titulo;
        this.atividade = atividade;
    }

    public AvaliacaoRequest() {
    }

    public Avaliacao paraAvaliacao(Aluno aluno) {
        return new Avaliacao(titulo,atividade,aluno);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAtividade() {
        return atividade;
    }
}
