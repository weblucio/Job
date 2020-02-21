package com.capgemini.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.entities.Conta;
import com.capgemini.entities.DadosPessoais;
import com.capgemini.entities.Deposito;
import com.capgemini.entities.Saque;
import com.capgemini.services.Correntista;
import com.google.gson.Gson;


@RestController
@RequestMapping(value="/receptor")
public class Receptor {
	Gson gson;
	DadosPessoais dados;
	Correntista correntista;
	Conta conta=null;
	@RequestMapping(value="/novaconta/{nome}/{cpf}/{agencia}", method = RequestMethod.POST)

	public String criaNovaConta(@PathVariable("nome") String nome,@PathVariable("cpf") String cpf,@PathVariable("agencia") String agencia) {
		gson = new Gson();


		try {
			dados=new DadosPessoais(nome,Long.parseLong(cpf));
			conta=new Conta(agencia,Long.parseLong(cpf));

			correntista=new Correntista(dados,conta);
			correntista.abreConta();

			return		gson.toJson(conta);
		}catch(Exception e) {
			return gson.toJson(new Conta());	

		}
	}

	@RequestMapping(value="/deposito/{conta}/{valor}", method = RequestMethod.POST)

	public String deposito(@PathVariable("conta") String conta,@PathVariable("valor")String valor) {
		gson=new Gson();
		try {
			Deposito deposito=new Deposito();
			deposito.setConta(conta);
			deposito.setValue(new BigDecimal(valor));
			correntista=new Correntista();
			correntista.fazDeposito(deposito);


			return		gson.toJson(deposito);

		}catch(Exception e) {

			return gson.toJson(new Deposito());	
		}
	}


	@RequestMapping(value="/saque/{conta}/{valor}", method = RequestMethod.POST)

	public String saque(@PathVariable("conta") String conta,@PathVariable("valor")String valor) {
		try {
			gson=new Gson();

			Saque saque=new Saque();
			saque.setConta(conta);
			saque.setValue(new BigDecimal(valor));
			Conta objconta=new Conta();
			objconta.setNumerodaconta(conta);
			correntista=new Correntista(null,objconta);

			if(correntista.fazSaque(saque)) {

				return gson.toJson(saque);

			}else {

				return gson.toJson(new Saque());



			}

		}catch(Exception e) {

			System.out.println(e.getLocalizedMessage());
			return gson.toJson(new Saque());

		}



	}


	@RequestMapping(value="/listasaques", method = RequestMethod.GET)

	public List<String> listarSaques(@RequestParam("conta") String conta) {


		List<String> retorno=new ArrayList();

		try {

			Conta ct=new Conta();
			ct.setNumerodaconta(conta);
			correntista=new Correntista(null,ct);

			for(Saque saque:correntista.listaSaques()) {

				retorno.add(String.valueOf(saque.getValue()));

			}



			return retorno;
		}catch(Exception e) {

			return retorno;
		}




	}



	@RequestMapping(value="/listadepositos", method = RequestMethod.GET)

	public List<String> listarDepositos(@PathVariable("conta") String conta) {


		List<String> retorno=new ArrayList();

		try {

			Conta ct=new Conta();
			ct.setNumerodaconta(conta);
			correntista=new Correntista(null,ct);

			for(Deposito deposito:correntista.listaDepositos()) {

				retorno.add(String.valueOf(deposito.getValue()));

			}



			return retorno;
		}catch(Exception e) {

			return retorno;
		}

	}


	@RequestMapping(value="/login/{conta}", method = RequestMethod.GET)

	public String login(@PathVariable("conta") String conta) {

		Conta contas=new Conta();
		contas.setNumerodaconta(conta);
		correntista=new Correntista(null,contas);
		List<Conta> retornocontas=correntista.login();
		gson=new Gson();
		if(retornocontas.size()>0) {
			return gson.toJson(retornocontas.get(0));
		}else {
			return gson.toJson(new Conta());
		}

	}

	@RequestMapping(value="/saldo/{conta}", method = RequestMethod.GET)

	public String saldo(@PathVariable("conta") String conta) {

		gson=new Gson();
		Conta contas=new Conta();
		contas.setNumerodaconta(conta);
		correntista=new Correntista(null,contas);
		contas.setSaldo(correntista.saldo());
		return gson.toJson(contas);
	}

}
