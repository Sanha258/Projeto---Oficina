package executavel;

import java.util.ArrayList;

import model.bo.PessoaBO;
import model.vo.PessoaVO;

public class Executavel {

	public static void main(String[] args) {
		
		PessoaBO pessoaBO = new PessoaBO();
		
		// CADASTRAR PESSOA - (CP)
		//CADASTRO OK
		
		PessoaVO cp1 = new PessoaVO(0, "Adriano", "01234567899", 45);
		cp1 = pessoaBO.cadastrarPessoaBO(cp1);
		System.out.println(cp1.getIdPessoa() > 0 ? "Pessoa Cadastrada com Sucesso!!!" : "Houve um problema no Cadastro!!!");
		
		// CADASTRO OK
		PessoaVO cp2 = new PessoaVO(0, "Maria", "01234567898", 20);
		cp2 = pessoaBO.cadastrarPessoaBO(cp2);
		System.out.println(cp2.getIdPessoa() > 0 ? "Pessoa Cadastrada com Sucesso!!!" : "Houve um problema no Cadastro!!!");
		
		// CADASTRO OK

		PessoaVO cp3 = new PessoaVO(0, "Luciano", "01234567897", 40);
		cp3 = pessoaBO.cadastrarPessoaBO(cp3);
		System.out.println(cp3.getIdPessoa() > 0 ? "Pessoa Cadastrada com Sucesso!!!" : "Houve um problema no Cadastro!!!");
		
		//MENOR DE IDADE

		PessoaVO cp4 = new PessoaVO(0, "Jose", "01234567896", 15);
		cp4 = pessoaBO.cadastrarPessoaBO(cp4);
		System.out.println(cp4.getIdPessoa() > 0 ? "Pessoa Cadastrada com Sucesso!!!" : "Houve um problema no Cadastro!!!");
		
		// CPF NULO (VALIDADO PELO BANCO DE DADOS)

		PessoaVO cp5 = new PessoaVO(0, "Joao", null, 25);
		cp5 = pessoaBO.cadastrarPessoaBO(cp5);
		System.out.println(cp5.getIdPessoa() > 0 ? "Pessoa Cadastrada com Sucesso!!!" : "Houve um problema no Cadastro!!!");
		
		// TENTANDO CADASTRAR UMA PESSOA JÁ CADASTRADA

		cp1 = pessoaBO.cadastrarPessoaBO(cp1);
		System.out.println(cp1.getIdPessoa() > 0 ? "Pessoa Cadastrada com Sucesso!!!" : "Houve um problema no Cadastro!!!");
		
		System.out.println("---------------------------------------------------------");
		// ATUALIZAR PESSOA - (AP)
		//ATUALIZAÇAO OK
		
		PessoaVO ap1 = new PessoaVO(1, "", "", 0);
		ap1 = pessoaBO.consultarPessoaBO(ap1);
		ap1.setIdade(ap1.getIdade() + 1);
		boolean resultado = pessoaBO.atualizarPessoaBO(ap1);
		System.out.println(resultado? "Pessoa Atualizada com Sucesso!!!" : "Houve um problema na Atualizaçao!!!");
		
		//TENTANDO ATUALIZAR UMA PESSOA INEXISTENTE.
		PessoaVO ap2 = new PessoaVO(100, "", "", 0);
		ap2 = pessoaBO.consultarPessoaBO(ap2);
		ap2.setIdade(ap2.getIdade() + 1);
		resultado = pessoaBO.atualizarPessoaBO(ap2);
		System.out.println(resultado? "Pessoa Atualizada comm Sucesso!!!" : "Houve um problema na Atualizaçao!!!");
		
		//TENTANDO ATUALIZAR O CPF DE UMA PESSOA PARA NULL.
		PessoaVO ap3 = new PessoaVO(2, "", "", 0);
		ap3 = pessoaBO.consultarPessoaBO(ap3);
		ap3.setCpf(null);
		resultado = pessoaBO.atualizarPessoaBO(ap3);
		System.out.println(resultado? "Pessoa Atualizada com Sucesso!!!" : "Houve um problema na Atualizaçao!!!");
		
		//TENTANDO TRANSFORMAR UMA PESSOA EM MENOR DE IDADE.
		PessoaVO ap4 = new PessoaVO(2, "", "", 0);
		ap4 = pessoaBO.consultarPessoaBO(ap4);
		ap4.setIdade(10);
		resultado = pessoaBO.atualizarPessoaBO(ap4);
		System.out.println(resultado? "Pessoa Atualizada com Sucesso!!!" : "Houve um problema na Atualizaçao!!!");
		
		System.out.println("\n-------------------------------------------------\n");
		
		//EXCLUIR UMA PESSOA - (EP)
		//EXCLUSAO OK
		
		PessoaVO ep1 = new PessoaVO(2, "", "", 0);
		ep1 = pessoaBO.consultarPessoaBO(ep1);
		resultado = pessoaBO.excluirPessoaBO(ep1);
		System.out.println(resultado? "Pessoa Excluida com Sucesso!!!" : "Houve um problema na Exclusao!!!");
		
		//TENTANDO EXCLUIR UMA PESSOA INEXISTENTE.
		PessoaVO ep2 = new PessoaVO(100, "", "", 0);
		ep2 = pessoaBO.consultarPessoaBO(ep2);
		resultado = pessoaBO.excluirPessoaBO(ep2);
		System.out.println(resultado? "Pessoa Excluida com Sucesso!!!" : "Houve um problema na Exclusao!!!");
		
		System.out.println("\n-----------------------------------------------\n");
		
		//CONSULTAR UMA PESSOA OK
		PessoaVO p1 = new PessoaVO(3, "", null, 0);
		p1 = pessoaBO.consultarPessoaBO(p1);
		if(p1.getCpf() != null) {
			System.out.println(p1);	
		}else {
			System.out.println("\n Pessoa nao localizada na base de dados!!!");
		}
		
		//TENTANDO CONSULTAR UMA PESSOA INEXISTENTE.
		PessoaVO p2 = new PessoaVO(100, "", null, 0);
		p2 = pessoaBO.consultarPessoaBO(p2);
		if(p2.getCpf() != null) {
			System.out.println(p2);		
		}else {
			System.out.println("\n Pessoa nao localizada na base de dados!!!");
		}
		
		//CONSULTANDO TODAS AS PESSOAS
		ArrayList<PessoaVO> lista = pessoaBO.consultarTodasPessoasBO();
		if(lista.isEmpty()) {
			System.out.println("Nao existem pessoas cadastradas na base de dados!!!");
		}else {
			System.out.println("\n Lista de pessoas: \n");
			for(PessoaVO p : lista) {
				System.out.println(p + "\n");
			}
		}
		
	}

}
