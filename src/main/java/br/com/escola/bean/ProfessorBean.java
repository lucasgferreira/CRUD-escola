package br.com.escola.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.escola.dao.ProfessorDAO;
import br.com.escola.dao.TurmaDAO;
import br.com.escola.domain.Professor;
import br.com.escola.domain.Turma;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProfessorBean implements Serializable {
	private Professor professor;
	private List<Professor> professores;
	private List<Turma> turmas;

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
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
			ProfessorDAO professorDAO = new ProfessorDAO();
			professores = professorDAO.listar("Nome");
		} catch (RuntimeException e) {
			// TODO: handle exception
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os Professores!");
			e.printStackTrace();
		}
	}

	public void novo() {
		
		try {
			professor = new Professor();

			TurmaDAO turmaDAO = new TurmaDAO();
			turmas = turmaDAO.listar("Nome");

		} catch (RuntimeException e) {
			// TODO: handle exception
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os professores!");
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			ProfessorDAO professorDAO = new ProfessorDAO();
			professorDAO.merge(professor);

			professor = new Professor();
			professores = professorDAO.listar();
			
			TurmaDAO turmaDAO = new TurmaDAO();
			turmas = turmaDAO.listar("Nome");

			Messages.addGlobalInfo("Professor salvo com sucesso.");
		} catch (RuntimeException e) {
			// TODO: handle exception
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Professor!");
			e.printStackTrace();
		}
	}

	public void excluir(ActionEvent event) {
		try {
			professor = (Professor) event.getComponent().getAttributes().get("professorSelecionado");

			ProfessorDAO professorDAO = new ProfessorDAO();
			professorDAO.excluir(professor);
			
			professores = professorDAO.listar();
			Messages.addGlobalInfo("Professor: " + professor.getNome() + " foi removido com sucesso.");
		
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o Professor");
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent event) {
		try {
			professor = (Professor) event.getComponent().getAttributes().get("professorSelecionado");

			ProfessorDAO professorDAO = new ProfessorDAO();
			professorDAO.editar(professor);
			
			professores = professorDAO.listar("Nome");
		
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar o Professor");
			e.printStackTrace();
		}
	}
}

