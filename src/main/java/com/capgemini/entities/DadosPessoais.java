package com.capgemini.entities;

public class DadosPessoais {
	
	Long id=0L;
	String nome="";

	Conta conta;
	
	long cpf=0L;


	
	//Construtor
	public DadosPessoais(String nome,Long cpf) {

		this.nome=nome;
		this.cpf=cpf;
	}
	
	//getters e setters

	
	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


}
