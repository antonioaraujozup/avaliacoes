package br.com.zup.edu.avaliacoes.api.model;

import javax.persistence.*;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String atividade;

    @ManyToOne(optional = false)
    private Aluno aluno;

    public Avaliacao(String titulo, String atividade, Aluno aluno) {
        this.titulo = titulo;
        this.atividade = atividade;
        this.aluno = aluno;
    }

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Avaliacao() {
    }

    public Long getId() {
        return id;
    }
}
