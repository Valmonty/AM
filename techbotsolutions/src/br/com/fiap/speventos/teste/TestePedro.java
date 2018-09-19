package br.com.fiap.speventos.teste;

import br.com.fiap.speventos.beans.PessoaFisica;
import br.com.fiap.speventos.bo.PessoaFisicaBO;
import br.com.fiap.speventos.excecao.Excecao;

public class TestePedro {

	public static void main(String[] args) {

		try {
			
			PessoaFisicaBO pfBO = new PessoaFisicaBO();
			
			PessoaFisica testePf = new PessoaFisica(
					19, 
					"pedeo@pedero.com", 
					"ci345678", 
					"pedro ass", 
					11111111111L, 
					"rua de fatima",
					121121122L, 
					12, 
					12122121, 
					'z', 
					'm', 
					"21/12/2000");
			
			pfBO.novoPessoaFisica(testePf);
			
			PessoaFisica objRetornado = pfBO.consultaPessoaFisicaPorCodigo(31);
			
			System.out.println(objRetornado.getCodigoUsuario());
			System.out.println(objRetornado.getEmail());
			System.out.println(objRetornado.getSenha());
			System.out.println(objRetornado.getNome());
			System.out.println(objRetornado.getTelefone());
			System.out.println(objRetornado.getEndereco());
			System.out.println(objRetornado.getCpf());
			System.out.println(objRetornado.getCpfDigito());
			System.out.println(objRetornado.getRg());
			System.out.println(objRetornado.getRgDigito());
			System.out.println(objRetornado.getGenero());
			System.out.println(objRetornado.getDataNascimento());	
			
//			int codigoUsuario, String email, String senha, String nome, long telefone, 
//			String endereco, long cpf, int cpfDigito, int rg, char rgDigito, 
//			char genero, String dataNascimento)
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Excecao.tratarExcecao(e));
		} 
	}

}
