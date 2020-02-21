package com.capgemini.repositorio;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.entities.DadosPessoais;
import com.capgemini.tables.Tables;

public class DAODadosPessoais implements DAO {


	public boolean insere(Object obj) {
		// TODO Auto-generated method stubon		
		DadosPessoais dados=(DadosPessoais)obj;
		Tables.tabela_dadospessoais.add(dados);
		
		return true;
	}

	public List<Object> selectAll(Object obj) {
		// TODO Auto-generated method stub
	
		
		List<Object> lista=Tables.tabela_dadospessoais.stream()
				.filter(filtro->filtro.getConta()
				.equals(((DadosPessoais)obj).getConta())).collect(Collectors.toList());
		return lista;
	}

	
	

}
