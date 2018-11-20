package br.com.escola.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Aluno extends GenericDomain {

	@ManyToOne
	@JoinColumn(nullable = false)
	private Turma turma;
	
	@Column(length = 100, nullable = false)
	private String Nome;

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
	
	
}
