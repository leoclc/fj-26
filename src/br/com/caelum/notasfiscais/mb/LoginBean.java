package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;


@SessionScoped
@ManagedBean
public class LoginBean {
	private Usuario usuario = new Usuario();
	
	public void efetuaLogin(){
		UsuarioDAO dao = new UsuarioDAO();
		boolean loginValido = dao.existe(this.usuario);
		System.out.println("O login era valido? "+loginValido);
	}
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
}
