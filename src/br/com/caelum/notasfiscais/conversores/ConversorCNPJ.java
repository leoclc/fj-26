package br.com.caelum.notasfiscais.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.caelum.stella.format.CNPJFormatter;
@FacesConverter("cnpj")
public class ConversorCNPJ implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return new CNPJFormatter().unformat(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		try{
		return new CNPJFormatter().format(arg2.toString());
		}
		catch(Exception e){
			System.out.println("Deu pau!");
		}
		return arg2.toString();
	}
	
}
