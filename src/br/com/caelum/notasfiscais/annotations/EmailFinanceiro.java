package br.com.caelum.notasfiscais.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

@Target(ElementType.FIELD) @Retention(RetentionPolicy.RUNTIME) @Qualifier
public @interface EmailFinanceiro {

}
