package com.bhaiti.kela.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhaiti.kela.beans.Cliente;
import com.bhaiti.kela.beans.VerificarClienteReply;

@Controller
public class VerificarClienteController {
	
@RequestMapping(method = RequestMethod.GET, value="/cliente/verificar/{cedula}/{fecha}/{tipotx}/{valor}")
	
	@ResponseBody
	public VerificarClienteReply verificarCliente(@PathVariable("cedula") String cedula, @PathVariable("fecha") String fecha, @PathVariable("tipotx") String tipotx, @PathVariable("valor") Double valor) {		
		System.out.printf("Verificando cliente %s \n", cedula); 
	    Cliente cliente = new Cliente();
	    cliente.setCedula(cedula);
	    cliente.setFecha(fecha);
	    cliente.setTipoTx(tipotx);
	    cliente.setValor(valor);
	    
	    //validaciones irian aca
	    
	    VerificarClienteReply response = new VerificarClienteReply();
	    response.setNumCuenta(0);
	    return response;
	}	
}
