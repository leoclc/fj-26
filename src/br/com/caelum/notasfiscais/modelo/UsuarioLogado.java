package br.com.caelum.notasfiscais.modelo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UsuarioLogado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lastURL ="produto?faces-redirect=true";
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}
	
	public boolean isLogado(){
		return usuario != null;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getLastURL() {
		return lastURL;
	}

	public void setLastURL(String lastURL) {
		this.lastURL = lastURL;
	}

}
