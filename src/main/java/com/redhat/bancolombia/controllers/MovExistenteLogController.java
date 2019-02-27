package com.redhat.bancolombia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redhat.bancolombia.beans.Cliente;
import com.redhat.bancolombia.beans.ClienteCuenta;
import com.redhat.bancolombia.beans.MovimientoReply;

@Controller
public class MovExistenteLogController {
@RequestMapping(method = RequestMethod.GET, value="/cliente/movimiento/log/{numcuenta}/{fecha}/{tipotx}/{valor}")
	
	@ResponseBody
	public MovimientoReply movExistenteLog(@PathVariable("numcuenta") String numcuenta, @PathVariable("fecha") String fecha, @PathVariable("tipotx") String tipotx, @PathVariable("valor") Double valor) {		
	System.out.printf("Verificando movimientos en log de cliente con cuenta %s \n", numcuenta); 
    ClienteCuenta clienteCuenta = new ClienteCuenta();
    clienteCuenta.setNumCuenta(numcuenta);
    clienteCuenta.setFecha(fecha);
    clienteCuenta.setTipoTx(tipotx);
    clienteCuenta.setValor(valor);
    
    //con el numero de cuenta fecha tipotx(1,2,3) y valor si existe la transaccion
    //fecha con formato ddmmyy -> 250219
    ClienteCuenta c1 = new ClienteCuenta("220033110520","250219", "3", 55.90);
    ClienteCuenta c2 = new ClienteCuenta("220033110521","250219", "2", 100.00);
    ClienteCuenta c3 = new ClienteCuenta("220033110522","250219", "1", 205.15);
    ClienteCuenta c4 = new ClienteCuenta("220033110523","250219", "2", 15.00);
    ClienteCuenta c5 = new ClienteCuenta("220033110524","250219", "3", 50.90);
    ClienteCuenta c6 = new ClienteCuenta("220033110525","250219", "2", 100.00);
    ClienteCuenta c7 = new ClienteCuenta("220033110526","250219", "1", 195.15);
    ClienteCuenta c8 = new ClienteCuenta("220033110527","250219", "2", 150.00);
    ClienteCuenta[] clientes = new ClienteCuenta[] {c1,c2,c3,c4, c5, c6, c7, c8};
    
    MovimientoReply response = new MovimientoReply();
    response.setExiste(false);
	response.setValor(0.00);
	response.setFecha("");
	response.setNumCuenta("");
	
    for (ClienteCuenta c : clientes) {
    	System.out.printf("Los valores a validar son -> cuenta: %s || fecha: %s || tipoTx: %s || valor: %f \n", c.getNumCuenta(), c.getFecha(), c.getTipoTx(), c.getValor());
		if (c.getNumCuenta().equals(clienteCuenta.getNumCuenta()) && c.getFecha().equals(clienteCuenta.getFecha()) && c.getTipoTx().equals(clienteCuenta.getTipoTx())) {
			response.setExiste(true);
			response.setValor(c.getValor());
			response.setFecha(c.getFecha());
			response.setNumCuenta(c.getNumCuenta());
			System.out.printf("Movimiento en Log encontrado -> cuenta: %s || fecha: %s || tipoTx: %s || valor: %f \n", c.getNumCuenta(), c.getFecha(), c.getTipoTx(), c.getValor());
			break;
		}				
	}
    return response;
	}
}
