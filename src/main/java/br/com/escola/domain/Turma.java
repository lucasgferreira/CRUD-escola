package br.com.escola.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Turma extends GenericDomain {
	
	@Column(length = 100, nullable = false)
	private String Nome;

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
}
