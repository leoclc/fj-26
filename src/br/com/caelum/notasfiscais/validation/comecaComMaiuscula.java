package br.com.caelum.notasfiscais.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("maiuscula")
public class comecaComMaiuscula implements Validator {

	@Override
	public void validate(FacesContext ctx, UIComponent comp, Object value)
			throws ValidatorException {
		 String valor = value.toString();
			if(!valor.matches("[A-Z].*")){
				throw new ValidatorException(new FacesMessage("Deveria começar com maiúscula"));
			}
	}

}
