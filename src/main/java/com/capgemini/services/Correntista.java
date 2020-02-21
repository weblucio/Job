package com.capgemini.services;

import java.math.BigDecimal;
import java.util.List;

import com.capgemini.entities.Conta;
import com.capgemini.entities.DadosPessoais;
import com.capgemini.entities.Deposito;
import com.capgemini.entities.Saque;
import com.capgemini.repositorio.DAO;
import com.capgemini.repositorio.DAOConta;
import com.capgemini.repositorio.DAODadosPessoais;
import com.capgemini.repositorio.DAODeposito;
import com.capgemini.repositorio.DAOSaques;

public class Correntista {

	DadosPessoais dadospessoais;
	Conta conta;
	public Correntista() {



	}

	public Correntista(DadosPessoais dados,Conta conta) {
		this.dadospessoais=dados;
		this.conta=conta;


	}

	//metodos
	public boolean abreConta() {

		if(cadastraCliente()) {

			DAO dao=new DAOConta();

			dao.insere(this.conta);
		}

		return true;
	}

	public boolean cadastraCliente() {
		DAO dao=new DAODadosPessoais();
		dao.insere(this.dadospessoais);

		return true;		
	}

	public boolean fazDeposito(Deposito deposito) {

		DAO dao=new DAODeposito();
		if(dao.insere(deposito)) {

			return true;


		}else {
			return false;

		}


	}

	public boolean fazSaque(Saque saque) {
		System.out.println("Comparação "+this.saldo().compareTo(saque.getValue()));
		if(this.saldo().compareTo(saque.getValue())==-1) {


			return false;

		}else {
			DAO dao=new DAOSaques();
			if(dao.insere(saque)) {

				return true;

			}else {
				return false;
			}



		}

	}

	public List<Saque> listaSaques() {

		DAOSaques saques=new DAOSaques();


		return saques.selectAll(this.conta);

	}


	public List<Deposito> listaDepositos() {

		DAODeposito depositos=new DAODeposito();

		return depositos.selectAll(this.conta);

	}

	public BigDecimal saldo() {
		BigDecimal totaldeposito=new BigDecimal("0.00");
		DAODeposito deposito=new DAODeposito();
		List <Deposito> depositos=deposito.selectAll(this.conta);

		for(Deposito dep:depositos) {
			System.out.print("Verificando depositos=>"+dep.getValue());	
			try {
				totaldeposito=totaldeposito.add(dep.getValue());
			}catch(Exception e) {

				System.out.print(e.getMessage());	


			}
		}


		BigDecimal totalsaques=new BigDecimal("0.00");
		DAOSaques saque=new DAOSaques();

		List <Saque> saques=saque.selectAll(this.conta);

		for(Saque saq:saques) {

			totalsaques=totalsaques.add(saq.getValue());

		}

		return totaldeposito.subtract(totalsaques);
	}

	public List<Conta> login() {

		DAOConta conta=new DAOConta();
		return conta.selectAll(this.conta);
	}







}
