package com.livraria.livraria.domain.livro;

public record DadosDetalhamentoLivro(Long id, String nome, String autor, String tema) {
	public DadosDetalhamentoLivro(Livro livro) {
        this(livro.getId(), livro.getNome(), livro.getAutor(), livro.getTema());
	}
}
