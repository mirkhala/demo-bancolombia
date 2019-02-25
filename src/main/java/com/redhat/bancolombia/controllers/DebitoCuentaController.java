package com.redhat.bancolombia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redhat.bancolombia.beans.Cliente;
import com.redhat.bancolombia.beans.DepositoReply;

@Controller
public class DebitoCuentaController {
@RequestMapping(method = RequestMethod.POST, value="/cliente/debito/cuenta/{numcuenta}/{fecha}/{tipotx}/{valor}")
	
	@ResponseBody
	public DepositoReply debitoCuenta(@PathVariable("numcuenta") String numcuenta, @PathVariable("fecha") String fecha, @PathVariable("tipotx") String tipotx, @PathVariable("valor") Double valor) {		
		System.out.printf("Verificando movimientos en cuenta de cliente con cuenta %s \n", numcuenta); 
	    Cliente cliente = new Cliente();
	    cliente.setCedula(numcuenta);
	    cliente.setFecha(fecha);
	    cliente.setTipoTx(tipotx);
	    cliente.setValor(valor);
	    
	    //con el numero de cuenta fecha tipotx(1,2,3) y valor si existe la transaccion
	    switch (tipotx) {
		//debito
	    case "1":
			System.out.printf("Se realizo el debito de la cuenta %s con un valor de %f \n",numcuenta, valor);
			break;
		//credito
		case "2":
			System.out.printf("Se realizo el credito de la cuenta %s con un valor de %f \n",numcuenta, valor);
			break;
		//retiro
		default:
			System.out.printf("Se realizo el retiro de la cuenta %s con un valor de %f \n",numcuenta, valor);
			break;
		}
	    
	    //devolver true y valor (default 0 si no se encuentra)
	    DepositoReply response = new DepositoReply();
	    response.setTxEfectuada(true);
	    response.setMsg("Transaccion efectuada con exito");
	    return response;
	}
}
