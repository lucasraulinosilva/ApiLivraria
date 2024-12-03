package com.livraria.livraria.domain.livro;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLivro(@NotNull Long id, String nome, String autor, String tema) {

}
