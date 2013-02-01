package br.com.caelum.notasfiscais.datamodel;

import javax.enterprise.inject.Produces;

import br.com.caelum.notasfiscais.annotations.EmailComercial;
import br.com.caelum.notasfiscais.annotations.EmailFinanceiro;

public class EmailFactory {
@Produces @EmailComercial
private String emailComercial = "comercial@uberdist.com.br";

@Produces @EmailFinanceiro
private String emailFinanceiro = "financeiro@uberdist.com.br";
}
