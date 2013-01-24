package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;


@SessionScoped
@ManagedBean
public class LoginBean {
	private Usuario usuario = new Usuario();
	
	public String efetuaLogin(){
		UsuarioDAO dao = new UsuarioDAO();
		boolean loginValido = dao.existe(this.usuario);
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
