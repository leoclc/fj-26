package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;


@SessionScoped
@Named
public class LoginBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario = new Usuario();
	@Inject
	private UsuarioDAO dao;
	
	public String efetuaLogin(){
		boolean loginValido = this.dao.existe(this.usuario);
		if(loginValido){
			return "produto";
		}else{
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public boolean isLogado(){
		return usuario.getLogin() != null;
	}
	
	public String logout(){
		this.usuario = new Usuario();
		return "login";
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
}
