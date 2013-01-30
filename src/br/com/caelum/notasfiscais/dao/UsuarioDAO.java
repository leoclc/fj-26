package br.com.caelum.notasfiscais.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.modelo.Usuario;

public class UsuarioDAO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
	
	public boolean existe(Usuario usuario) {
		em.getTransaction().begin();
		
		Query query = em.createQuery("from Usuario where login = :login and senha = :senha")
						.setParameter("login", usuario.getLogin())
						.setParameter("senha", usuario.getSenha());

		boolean encontrado = !query.getResultList().isEmpty();
		em.getTransaction().commit();
		return encontrado;
	}
	
	
	public boolean existeNomeDoProduto(String nome){
		Query query = em.createQuery("Select nome from Produto");
		List<String> list = (List<String>) query.getResultList();
			if(list.contains(nome)){
				return true;
			}
		return false;
	}
	
}