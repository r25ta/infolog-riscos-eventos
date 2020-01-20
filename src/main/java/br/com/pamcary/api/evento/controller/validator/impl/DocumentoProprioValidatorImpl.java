package br.com.pamcary.api.evento.controller.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.pamcary.api.evento.controller.validator.DocumentoProprioValidator;

public class DocumentoProprioValidatorImpl implements ConstraintValidator<DocumentoProprioValidator, String> {

	@Override
	public boolean isValid(String codDocum, ConstraintValidatorContext context) {
		if (!isDocumentoProprio(codDocum)) {
			return false;

		}
		return true;

	}
	private boolean isDocumentoProprio(String codDocum) {
		if(!codDocum.matches("[a-zA-Z0-9]+")) {
			return false;
		}
		return true;
	}
}
