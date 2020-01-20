package br.com.pamcary.api.evento.controller.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.pamcary.api.evento.controller.validator.impl.NumeroViagemValidatorImpl;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumeroViagemValidatorImpl.class)
public @interface NumeroViagemValidator {
	Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    String message() default "Identificador de viagem Inválido!";
    

    String value() default "";
}
