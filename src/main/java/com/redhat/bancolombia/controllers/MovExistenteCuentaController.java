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
	    Cliente c1 = new Cliente("220033110520","250219", "3", 55.90);
	    Cliente c2 = new Cliente("220033110521","250219", "2", 120.33);
	    Cliente c3 = new Cliente("220033110522","250219", "1", 255.15);
	    Cliente c4 = new Cliente("220033110523","250219", "2", 15.00);
	    Cliente[] clientes = new Cliente[] {c1,c2,c3,c4};
	    MovimientoReply response = new MovimientoReply();
	    response.setExiste(false);
		response.setValor(0.00);
	    for (Cliente c : clientes) {
	    	System.out.printf("Los valores a validar son -> cuenta: %s || fecha: %s || tipoTx: %s || valor: %f \n", c.getCedula(), c.getFecha(), c.getTipoTx(), c.getValor());
			if (c.getCedula().equals(cliente.getCedula()) && c.getFecha().equals(cliente.getFecha()) && c.getTipoTx().equals(cliente.getTipoTx()) && c.getValor().equals(cliente.getValor())) {
				response.setExiste(true);
				response.setValor(c.getValor());
				System.out.printf("Movimiento en Cuenta encontrado -> cuenta: %s || fecha: %s || tipoTx: %s || valor: %f \n", c.getCedula(), c.getFecha(), c.getTipoTx(), c.getValor());
				break;
			}				
		}
	    return response;
	}
}
