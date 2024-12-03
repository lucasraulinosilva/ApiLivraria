package com.livraria.livraria.domain.livro;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroLivro(@NotBlank String nome, @NotBlank String autor, @NotBlank String tema) {
}
