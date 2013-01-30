package br.com.caelum.notasfiscais.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.jboss.seam.faces.validation.InputField;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;

@FacesValidator("nomeigual")
public class ValidadorNomeIgual implements Validator{
	
	@Inject
	private UsuarioDAO dao;
	
	@Inject @InputField
	private String nome;
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
			if(dao.existeNomeDoProduto(nome)) throw new ValidatorException(new FacesMessage("Nome nao pode ser igual"));
	}

}
