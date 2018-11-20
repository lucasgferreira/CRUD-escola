package br.com.escola.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.com.escola.dao.PessoaDAO;
import br.com.escola.dao.UsuarioDAO;
import br.com.escola.domain.Pessoa;
import br.com.escola.domain.Usuario;
import br.com.escola.enumeracao.TipoUsuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Long codigoPessoa = 1L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		Usuario usuario = new Usuario();
		usuario.setSenhaSemCriptografia("abc");

		SimpleHash hash = new SimpleHash("sha-256", usuario.getSenhaSemCriptografia());
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenha(hash.toHex());
		usuario.setTipoUsuario(TipoUsuario.ADMINISTRADOR);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
	}
}
