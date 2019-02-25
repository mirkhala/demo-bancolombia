package com.redhat.bancolombia.beans;

public class DepositoReply {
	
	Boolean txEfectuada;
	String msg;
	public Boolean getTxEfectuada() {
		return txEfectuada;
	}
	public void setTxEfectuada(Boolean txEfectuada) {
		this.txEfectuada = txEfectuada;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
