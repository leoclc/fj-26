package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.modelo.UsuarioLogado;

@RequestScoped
@Named
public class LoginBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	@Inject
	private UsuarioDAO dao;
	
	@Inject
	private UsuarioLogado logado;
	
	public String efetuaLogin(){
		boolean loginValido = this.dao.existe(this.usuario);
		if(loginValido){
			logado.setUsuario(usuario);
			return "produto?faces-redirect=true";
		}else{
			usuario.setLogin("");
			logado.setUsuario(null);
			return "login";
		}
	}
	
	public boolean isLogado(){
		return logado.isLogado();
	}
	
	public String logout(){
		logado.setUsuario(null);
		return "login";
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
}
