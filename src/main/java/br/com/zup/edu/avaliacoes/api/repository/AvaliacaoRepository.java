package br.com.zup.edu.avaliacoes.api.repository;

import br.com.zup.edu.avaliacoes.api.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}
