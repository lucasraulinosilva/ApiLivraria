package com.livraria.livraria.domain.livro;

public record DadosListagemLivro(Long id, String nome, String autor, String tema) {
	public DadosListagemLivro(Livro livro) {
        this(livro.getId(), livro.getNome(), livro.getAutor(), livro.getTema());
	}
}
