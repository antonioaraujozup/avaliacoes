package br.com.zup.edu.avaliacoes.api.controller;

import br.com.zup.edu.avaliacoes.api.model.Aluno;
import br.com.zup.edu.avaliacoes.api.repository.AlunoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/alunos")
public class CadastrarNovoAlunoController {

    private final AlunoRepository repository;

    public CadastrarNovoAlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid AlunoRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Aluno novoAluno = request.paraAluno();

        repository.save(novoAluno);

        URI location = uriComponentsBuilder.path("/alunos/{id}")
                .buildAndExpand(novoAluno.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

}
