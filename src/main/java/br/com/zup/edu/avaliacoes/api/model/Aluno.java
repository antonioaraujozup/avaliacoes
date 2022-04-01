package br.com.zup.edu.avaliacoes.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String bootcamp;

    @Column(nullable = false)
    private LocalDateTime dataHoraCadastro = LocalDateTime.now();

    public Aluno(String nome, String email, String bootcamp) {
        this.nome = nome;
        this.email = email;
        this.bootcamp = bootcamp;
    }

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Aluno() {
    }

    public Long getId() {
        return id;
    }
}
