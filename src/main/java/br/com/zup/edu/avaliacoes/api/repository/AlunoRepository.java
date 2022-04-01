package br.com.zup.edu.avaliacoes.api.repository;

import br.com.zup.edu.avaliacoes.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
