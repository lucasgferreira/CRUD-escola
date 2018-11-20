package br.com.escola.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.escola.domain.Turma;


public class TurmaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Turma estado = new Turma();
		estado.setNome("Teste");

		TurmaDAO turmaDAO = new TurmaDAO();
		turmaDAO.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		TurmaDAO turmaDAO = new TurmaDAO();
		List<Turma> resultado = turmaDAO.listar();

		for (Turma turma : resultado) {
			System.out.println(turma.getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;

		TurmaDAO turmaDAO = new TurmaDAO();
		Turma turma = turmaDAO.buscar(codigo);

		if (turma == null) {
			System.out.println("Nenhum Resultado!");
		} else {
			System.out.println(turma.getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;

		TurmaDAO turmaDAO = new TurmaDAO();
		Turma turma = turmaDAO.buscar(codigo);
		
		if (turma == null) {
			System.out.println("Nenhum Resultado!");
		} else {
			turmaDAO.excluir(turma);
			System.out.println(turma.getCodigo() + " - " + turma.getNome() + " Turma excluida");
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigo = 2L;

		TurmaDAO turmaDAO = new TurmaDAO();
		Turma turma = turmaDAO.buscar(codigo);
		
		if (turma == null) {
			System.out.println("Nenhum Resultado!");
		} else {
			//estado.setNome("Test");
			turma.setNome("teste editado");

			turmaDAO = new TurmaDAO();
			turmaDAO.editar(turma);
			System.out.println(turma.getCodigo() + " - " + turma.getNome() + " Turma editada");
		}
	}
}
