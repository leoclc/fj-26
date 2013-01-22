package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public void grava(){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		dao.adiciona(produto);
		this.produto = new Produto();
		this.produtos = dao.listaTodos();
	}

	public List<Produto> getProdutos() {
		if(produtos==null){
		System.out.println("Carregando produtos...");
		produtos = new DAO<Produto>(Produto.class).listaTodos();
		}
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
