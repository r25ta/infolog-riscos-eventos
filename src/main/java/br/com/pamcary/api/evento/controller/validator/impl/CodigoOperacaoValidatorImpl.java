package br.com.pamcary.api.evento.controller.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.pamcary.api.evento.controller.validator.CodigoOperacaoValidator;

public class CodigoOperacaoValidatorImpl implements ConstraintValidator<CodigoOperacaoValidator, Integer> {

	public boolean isValid(Integer ctlOperaTip, ConstraintValidatorContext context) {
			if(!isCtlOperaTip(ctlOperaTip)) {
				return false;
			}
			
			return true;
	
	}

	private boolean isCtlOperaTip(Integer ctlOperaTip) {
		if(ctlOperaTip<=0) {
			return false;
		}
		
		try {
			new Integer(ctlOperaTip);
			return true;
			
		}catch (NumberFormatException e) {
			return false;
		}
	}
}
