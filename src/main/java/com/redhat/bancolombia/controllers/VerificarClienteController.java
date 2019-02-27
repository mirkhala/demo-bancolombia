package com.redhat.bancolombia.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redhat.bancolombia.beans.Cliente;
import com.redhat.bancolombia.beans.VerificarClienteReply;

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
	    
	    //seteo de datos para validar numero de cuenta
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("123456", "220033110520");
	    map.put("123457", "220033110521");
	    map.put("123458", "220033110522");
	    map.put("123459", "220033110523");
	    map.put("43278024", "220033110520-1");
	    map.put("1032567983", "220033110521-2");
	    map.put("52876234", "220033110522-3");
	    map.put("1031974569", "220033110523-4");

	    //validacion de cuenta existente
	    VerificarClienteReply response = new VerificarClienteReply();
	    if (map.containsKey(cedula))
	    	response.setNumCuenta(map.get(cedula));
	    else
	    	response.setNumCuenta("0");
	    
	    System.out.printf("VerificarClienteController.verificarCliente() --> cedula: %s || cuenta: %s \n", cedula, response.getNumCuenta());
	    return response;
	}	
}
