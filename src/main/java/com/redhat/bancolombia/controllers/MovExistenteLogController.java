package com.redhat.bancolombia.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redhat.bancolombia.beans.Cliente;
import com.redhat.bancolombia.beans.MovimientoReply;

@Controller
public class MovExistenteLogController {
@RequestMapping(method = RequestMethod.GET, value="/cliente/movimiento/log/{numcuenta}/{fecha}/{tipotx}/{valor}")
	
	@ResponseBody
	public MovimientoReply movExistenteLog(@PathVariable("numcuenta") String numcuenta, @PathVariable("fecha") String fecha, @PathVariable("tipotx") String tipotx, @PathVariable("valor") Double valor) {		
		System.out.printf("Verificando movimientos en log de cliente con cuenta %s \n", numcuenta); 
	    Cliente cliente = new Cliente();
	    cliente.setCedula(numcuenta);
	    cliente.setFecha(fecha);
	    cliente.setTipoTx(tipotx);
	    cliente.setValor(valor);
	    
	    // seteo de datos para validar numero de cuenta
	    // tomar en cuenta la fecha, tipotx (1,2,3), numcuenta 
	    Map<String, String> map = new HashMap<String, String>();
	    map.put("123456", "220033110520");
	    map.put("123457", "220033110521");
	    map.put("123458", "220033110522");
	    map.put("123459", "220033110523");
	    
	    
	  //devolver true y valor (default 0 si no se encuentra)
	    MovimientoReply response = new MovimientoReply();
	    response.setExiste(true);
	    response.setValor(125.20);
	    return response;
	}
}
