package br.com.zup.edu.avaliacoes.api.controller;

import br.com.zup.edu.avaliacoes.api.model.Aluno;
import br.com.zup.edu.avaliacoes.api.model.Avaliacao;
import br.com.zup.edu.avaliacoes.api.repository.AlunoRepository;
import br.com.zup.edu.avaliacoes.api.repository.AvaliacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/alunos/{idAluno}/avaliacoes")
public class CadastrarNovaAvaliacaoController {

    private final AlunoRepository alunoRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    public CadastrarNovaAvaliacaoController(AlunoRepository alunoRepository, AvaliacaoRepository avaliacaoRepository) {
        this.alunoRepository = alunoRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@PathVariable Long idAluno, @RequestBody @Valid AvaliacaoRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe aluno cadastrado para o id informado"));

        Avaliacao novaAvaliacao = request.paraAvaliacao(aluno);

        avaliacaoRepository.save(novaAvaliacao);

        URI location = uriComponentsBuilder.path("/alunos/{idAluno}/avaliacoes/{idAvaliacao}")
                .buildAndExpand(aluno.getId(), novaAvaliacao.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

}
