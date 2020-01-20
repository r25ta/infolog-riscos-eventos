package br.com.pamcary.api.evento.controller.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.pamcary.api.evento.controller.validator.NumeroViagemValidator;

public class NumeroViagemValidatorImpl implements ConstraintValidator<NumeroViagemValidator, Long> {

	public boolean isValid(Long ctlPlvia, ConstraintValidatorContext context) {
			if(!isCtlPlvia(ctlPlvia)) {
				return false;
			}
			
			return true;
	
	}

	private boolean isCtlPlvia(long ctlPlvia) {
		if(ctlPlvia<0) {
			return false;
		}
		
		try {
			new Long(ctlPlvia);
			return true;
			
		}catch (NumberFormatException e) {
			return false;
		}
	}
}
