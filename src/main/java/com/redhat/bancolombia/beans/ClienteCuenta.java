package com.redhat.bancolombia.beans;

public class ClienteCuenta {
	String numCuenta;
	String fecha;
	String tipoTx;
	Double valor;
	
	public ClienteCuenta(String cedula, String fecha, String tipoTx, Double valor) {
		super();
		this.numCuenta = cedula;
		this.fecha = fecha;
		this.tipoTx = tipoTx;
		this.valor = valor;
	}
	public ClienteCuenta() {
		super();
	}
	public String getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(String cedula) {
		this.numCuenta = cedula;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipoTx() {
		return tipoTx;
	}
	public void setTipoTx(String tipoTx) {
		this.tipoTx = tipoTx;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
