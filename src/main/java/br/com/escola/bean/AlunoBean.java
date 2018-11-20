package br.com.escola.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.escola.dao.AlunoDAO;
import br.com.escola.dao.TurmaDAO;
import br.com.escola.domain.Aluno;
import br.com.escola.domain.Turma;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {
	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Turma> turmas;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
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
			AlunoDAO alunoDAO = new AlunoDAO();
			alunos = alunoDAO.listar("Nome");
		} catch (RuntimeException e) {
			// TODO: handle exception
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os Alunos!");
			e.printStackTrace();
		}
	}

	public void novo() {
		
		try {
			aluno = new Aluno();

			TurmaDAO turmaDAO = new TurmaDAO();
			turmas = turmaDAO.listar("Nome");

		} catch (RuntimeException e) {
			// TODO: handle exception
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os alunos!");
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.merge(aluno);

			aluno = new Aluno();
			alunos = alunoDAO.listar();
			
			TurmaDAO turmaDAO = new TurmaDAO();
			turmas = turmaDAO.listar("Nome");

			Messages.addGlobalInfo("Aluno salvo com sucesso.");
		} catch (RuntimeException e) {
			// TODO: handle exception
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Aluno!");
			e.printStackTrace();
		}
	}

	public void excluir(ActionEvent event) {
		try {
			aluno = (Aluno) event.getComponent().getAttributes().get("alunoSelecionado");

			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.excluir(aluno);
			
			alunos = alunoDAO.listar();
			Messages.addGlobalInfo("Aluno: " + aluno.getNome() + " foi removida com sucesso.");
		
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o Aluno");
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent event) {
		try {
			aluno = (Aluno) event.getComponent().getAttributes().get("alunoSelecionado");

			AlunoDAO alunoDAO = new AlunoDAO();
			alunoDAO.editar(aluno);
			
			alunos = alunoDAO.listar("Nome");
		
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar o Aluno");
			e.printStackTrace();
		}
	}
}
