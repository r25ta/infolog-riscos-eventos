package br.com.pamcary.api.evento.controller.helper;

public class Util {
	 @SuppressWarnings("unused")
	private boolean isNumerico(String valor) { return valor.matches("[0-9]*"); }
	  
	  public String validarEntrada(Integer ctlOperaTip, Long ctlPlvia, String codDocum) {
	    String retorno = null;
	    try {
	      if (ctlOperaTip == null) {
	        retorno = " Campo operacao de preenchimento obrigatório!";
	      }
	    } catch (NumberFormatException e) {
	      retorno = " Campo operacao invalido [" + ctlOperaTip + "], o campo aceita somente caracteres numericos! ";
	    } 
	    
	    try {
	      if (ctlPlvia == null)
	      {
	        if (codDocum == null || codDocum.trim().equals("")) {
	          retorno = String.valueOf(retorno) + " Campo viagem e documento proprio não preenchidos! ";
	        }
	      }
	    }
	    catch (NumberFormatException e) {
	      retorno = String.valueOf(retorno) + " Campo viagem invalido [" + ctlPlvia + "], o campo aceita somente caracteres numericos! ";
	    } 
	    
	    return retorno;
	  }
}
