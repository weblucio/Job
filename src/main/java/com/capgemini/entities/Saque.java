package com.capgemini.entities;

import java.math.BigDecimal;

public class Saque {
	String conta="";
	BigDecimal value=new BigDecimal("0.00");
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	

}
