package com.redhat.bancolombia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redhat.bancolombia.beans.Cliente;
import com.redhat.bancolombia.beans.MovimientoReply;

@Controller
public class MovExistenteCuentaController {
@RequestMapping(method = RequestMethod.GET, value="/cliente/movimiento/cuenta/{numcuenta}/{fecha}/{tipotx}/{valor}")
	
	@ResponseBody
	public MovimientoReply movExistenteCuenta(@PathVariable("numcuenta") String numcuenta, @PathVariable("fecha") String fecha, @PathVariable("tipotx") String tipotx, @PathVariable("valor") Double valor) {		
		System.out.printf("Verificando movimientos en cuenta de cliente con cuenta %s \n", numcuenta); 
	    Cliente cliente = new Cliente();
	    cliente.setCedula(numcuenta);
	    cliente.setFecha(fecha);
	    cliente.setTipoTx(tipotx);
	    cliente.setValor(valor);
	    
	    //con el numero de cuenta fecha tipotx(1,2,3) y valor si existe la transaccion
	    
	    
	    //devolver true y valor (default 0 si no se encuentra)
	    MovimientoReply response = new MovimientoReply();
	    response.setExiste(true);
	    response.setValor(125.20);
	    return response;
	}
}
