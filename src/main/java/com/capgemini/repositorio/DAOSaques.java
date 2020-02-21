package com.capgemini.repositorio;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.entities.Conta;
import com.capgemini.entities.Deposito;
import com.capgemini.entities.Saque;
import com.capgemini.tables.Tables;

public class DAOSaques implements DAO{

	public boolean insere(Object obj) {
		// TODO Auto-generated method stubon		
		Saque saque=(Saque)obj;
		Tables.tabela_saque.add(saque);
		
		return true;
	}

	public List<Saque> selectAll(Object obj) {
		// TODO Auto-generated method stub
	
		
		List<Saque> lista=Tables.tabela_saque.stream()
				.filter(filtro->filtro.getConta()
				.equals(((Conta)obj).getNumerodaconta())).collect(Collectors.toList());
		return lista;
	}

}
