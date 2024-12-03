package com.livraria.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.livraria.livraria.domain.livro.DadosAtualizacaoLivro;
import com.livraria.livraria.domain.livro.DadosCadastroLivro;
import com.livraria.livraria.domain.livro.DadosDetalhamentoLivro;
import com.livraria.livraria.domain.livro.DadosListagemLivro;
import com.livraria.livraria.domain.livro.Livro;
import com.livraria.livraria.domain.livro.LivroRepository;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("livros")
public class LivroController {
	
	@Autowired
	private LivroRepository repository;
	
	@GetMapping
	public ResponseEntity<Page<DadosListagemLivro>> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao) {
		var page = repository.findAll(paginacao).map(DadosListagemLivro::new);
		return ResponseEntity.ok(page);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLivro dados, UriComponentsBuilder uriBuilder) {
		var livro = new Livro(dados);
		
		repository.save(livro);
		
		var uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoLivro(livro));
	}
	
    @SuppressWarnings({ "null", "rawtypes" })
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var livro = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoLivro(livro));
    }
    
    @SuppressWarnings({ "null", "rawtypes" })
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoLivro dados) {
        var livro = repository.getReferenceById(dados.id());
        livro.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoLivro(livro));

    }
    
    @SuppressWarnings({ "null", "rawtypes" })
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
    	repository.deleteById(id);
    	
    	return ResponseEntity.noContent().build();
    }
}
