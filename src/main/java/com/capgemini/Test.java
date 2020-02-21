package com.capgemini;

import com.capgemini.controller.Receptor;
import com.capgemini.tables.Tables;

public class Test {

	
	public static void main(String[] args) {
		
		
		Receptor receptor=new Receptor();

		String resultado=receptor.criaNovaConta("Lucio Mauro", "03989153692", "3435");		
	
		System.out.println("Tamanho da lista dados pessoais=>"+Tables.tabela_dadospessoais.get(0).getNome());

		System.out.println("Tamanho da lista contas=>"+Tables.tabela_conta.get(0).getAgencia());
		
	}


}
