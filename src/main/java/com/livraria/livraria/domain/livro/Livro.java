package com.livraria.livraria.domain.livro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "livros")
@Entity(name = "Livro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livro {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String autor;
	private String tema;
	
	public Livro(DadosCadastroLivro dados) {
		this.nome = dados.nome();
		this.autor = dados.autor();
		this.tema = dados.tema();
	}
	
	public void atualizarInformacoes(DadosAtualizacaoLivro dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        
        if (dados.tema() != null) {
            this.tema = dados.tema();
        }
        
        if (dados.autor() != null) {
            this.autor = dados.autor();
        }
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	
}
