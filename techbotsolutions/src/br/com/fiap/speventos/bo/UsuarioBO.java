package br.com.fiap.speventos.bo;

import br.com.fiap.speventos.beans.Usuario;
import br.com.fiap.speventos.dao.UsuarioDAO;

public class UsuarioBO {

	public static String novoUsuario(Usuario usuario) throws Exception{

		if(usuario.getCodigoUsuario()<=0) {
			return "C�digo inv�lido";
		}

		if(usuario.getNome().isEmpty() || usuario.getNome().length()>60) {
			return "Nome inv�lido";
		}

		if(usuario.getEmail().isEmpty() || usuario.getEmail().length()>60) {
			return "Email inv�lido";
		}

		if(usuario.getEmail().indexOf("@")<0 || usuario.getEmail().indexOf(".")<0) {
			return "Email invalido";
		}

		if(usuario.getSenha().length()<8 || usuario.getSenha().length()>20) {
			return "Senha inv�lida";
		}

		usuario.setNome(usuario.getNome().toUpperCase());
		usuario.setEmail(usuario.getEmail().toUpperCase());
		usuario.setSenha(usuario.getSenha().toUpperCase());

		UsuarioDAO dao = new UsuarioDAO();
		//Usuario resultado = dao.consultarPorCodigo(usuario.getCodigoUsuario());

		//		if(resultado.getCodigoUsuario()>0) {
		//			dao.fechar();
		//			return "Usu�rio j� existe";
		//		}

		String retorno = dao.cadastrar(usuario) + "registro inserido";
		dao.fechar();
		return retorno;
	}

	public static Usuario login(String email, String senha) throws Exception{

		//RNs, validacoes, etc

		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.logar(email, senha);
		dao.fechar();

		return usuario;
	}

	public static String edicaoUsuario(Usuario usuario) throws Exception{

		if(usuario.getCodigoUsuario()<=0) {
			return "C�digo inv�lido";
		}

		if(usuario.getNome().isEmpty() || usuario.getNome().length()>60) {
			return "Nome inv�lido";
		}

		if(usuario.getEmail().isEmpty() || usuario.getEmail().length()>60) {
			return "Email inv�lido";
		}

		if(usuario.getEmail().indexOf("@")<0 || usuario.getEmail().indexOf(".")<0) {
			return "Email invalido";
		}

		if(usuario.getSenha().length()<8 || usuario.getSenha().length()>20) {
			return "Senha inv�lida";
		}

		usuario.setNome(usuario.getNome().toUpperCase());
		usuario.setEmail(usuario.getEmail().toUpperCase());
		usuario.setSenha(usuario.getSenha().toUpperCase());

		UsuarioDAO dao = new UsuarioDAO();

		String retorno = dao.editar(usuario) + "registro editado";
		dao.fechar();
		return retorno;
	}

	public static String remocaoUsuario(int usuario) throws Exception{

		UsuarioDAO dao = new UsuarioDAO();

		//fazer if para comparacao do codigo, se <1 o codigo � invalido

		String retorno = dao.remover(usuario) + "registro removido";

		dao.fechar();
		return retorno;
	}
}