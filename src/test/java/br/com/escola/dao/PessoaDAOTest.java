package br.com.escola.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.com.escola.dao.PessoaDAO;
import br.com.escola.domain.Pessoa;

public class PessoaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("lucas");
		pessoa.setCpf("000.000.000-00");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
	}

}
