package br.com.escola.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.escola.dao.TurmaDAO;
import br.com.escola.domain.Turma;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TurmaBean implements Serializable {
	private Turma turma;
	private List<Turma> turmas;

	public Turma getTurma() {
		return turma;
	}

	public void setEstado(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	@PostConstruct
	public void listar() {
		try {
			TurmaDAO turmaDAO = new TurmaDAO();
			turmas = turmaDAO.listar();
		} catch (RuntimeException e) {
			// TODO: handle exception
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Turmas!");
			e.printStackTrace();
		}
	}

	public void novo() {
		turma = new Turma();
	}

	public void salvar() {
		try {
			TurmaDAO turmaDAO = new TurmaDAO();
			turmaDAO.merge(turma);

			turma = new Turma();
			turmas = turmaDAO.listar();

			Messages.addGlobalInfo("Turma salva com sucesso.");
		} catch (RuntimeException e) {
			// TODO: handle exception
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a Turma!");
			e.printStackTrace();
		}
	}

	public void excluir(ActionEvent event) {
		try {
			turma = (Turma) event.getComponent().getAttributes().get("turmaSelecionada");

			TurmaDAO turmaDAO = new TurmaDAO();
			turmaDAO.excluir(turma);
			
			turmas = turmaDAO.listar();
			Messages.addGlobalInfo("Turma: " + turma.getNome() + " foi removida com sucesso.");
		
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir a Turma");
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent event) {
		try {
			turma = (Turma) event.getComponent().getAttributes().get("turmaSelecionada");

			TurmaDAO turmaDAO = new TurmaDAO();
			turmaDAO.editar(turma);
			
			turmas = turmaDAO.listar();
		
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar a Turma");
			e.printStackTrace();
		}
	}
}

