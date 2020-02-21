package com.capgemini.entities;

import java.math.BigDecimal;
import java.util.List;

public class Conta {
	long id_cliente=0L;
	String agencia;
	int digito;
	String numerodaconta="";
	BigDecimal saldo=new BigDecimal("0.00");
	//todos os saques ocorridos nessas conta sao carregados aqui
	List<Saque> saques;
	//todos os depositos ocorridos nessas conta sao carregados aqui
	List<Deposito> depositos;

	//Construtores
	public Conta(){
		
		
	}
	//contrutor para criação de conta
	public Conta(String agencia,long cpf) {
		this.agencia=agencia;
		this.id_cliente=cpf;
		
	}
	//getters e setters
	
	public List<Saque> getSaques() {
		return saques;
	}
	public void setSaques(List<Saque> saques) {
		this.saques = saques;
	}
	public List<Deposito> getDepositos() {
		return depositos;
	}
	public void setDepositos(List<Deposito> depositos) {
		this.depositos = depositos;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public int getDigito() {
		return digito;
	}
	public void setDigito(int digito) {
		this.digito = digito;
	}
	public String getNumerodaconta() {
		return numerodaconta;
	}
	public void setNumerodaconta(String numerodaconta) {
		this.numerodaconta = numerodaconta;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	

}
