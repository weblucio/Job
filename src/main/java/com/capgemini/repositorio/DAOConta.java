package com.capgemini.repositorio;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import com.capgemini.entities.Conta;
import com.capgemini.tables.Tables;

public class DAOConta implements DAO{

	public boolean insere(Object obj) {
		// TODO Auto-generated method stubon
		Random random = new Random();
		Conta conta=(Conta)obj;
		Tables.tabela_conta.add(conta);
		Tables.tabela_conta.get(Tables.tabela_conta.size()-1).setNumerodaconta(String.valueOf(random.nextInt(100)+random.nextInt(100)+random.nextInt(100)));
		return true;
	}

	public List<Conta> selectAll(Object obj) {
		// TODO Auto-generated method stub
	
		
		List<Conta> lista=Tables.tabela_conta.stream()
				.filter(filtro->filtro.getNumerodaconta()
				.equals(((Conta)obj).getNumerodaconta())).collect(Collectors.toList());
		return lista;
	}



}
