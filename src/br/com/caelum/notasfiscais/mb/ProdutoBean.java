package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.persistence.Id;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ViewScoped
@Named
public class ProdutoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Produto produto = new Produto();
	private List<Produto> produtos;
	private Long produtoId;
	
	public Produto getProduto() {
		return this.produto;
	}
	
	public void carregaProduto(){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		if(produtoId != null && produtoId != 0){
			this.produto = dao.buscaPorId(this.produtoId);
		}
	}
	
	public void grava(){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		if(getProduto().getId()==null){
			dao.adiciona(getProduto());
		} else {
			dao.atualiza(getProduto());
		}
		this.produtos = dao.listaTodos();
		this.setProduto(new Produto());
	}
	
	public void cancela(){
		this.produto = new Produto();
	}
	
	public void remove(Produto produto){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		dao.remove(produto);
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

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long id) {
		this.produtoId = id;
	}
}
