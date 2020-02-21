package com.capgemini.repositorio;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.entities.Conta;
import com.capgemini.entities.Deposito;
import com.capgemini.tables.Tables;

public class DAODeposito implements DAO{

	public boolean insere(Object obj) {
		// TODO Auto-generated method stubon		
		
		try{Deposito deposito=(Deposito)obj;
		Tables.tabela_deposito.add(deposito);
		
		
		return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
				
			return false;
		}
		
		}

	public List<Deposito> selectAll(Object obj) {
		// TODO Auto-generated method stub
	
		
		List<Deposito> lista=Tables.tabela_deposito.stream()
				.filter(filtro->filtro.getConta()
				.equals(((Conta)obj).getNumerodaconta())).collect(Collectors.toList());
		return lista;
	}

	
	


}
