package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {
	private Produto produto = new Produto();

	public Produto getProduto() {
		return this.produto;
	}
	
	public void grava(){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		dao.adiciona(produto);
		this.produto = new Produto();
	}
}
