package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ViewScoped
@ManagedBean
public class ProdutoBean {
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	public Produto getProduto() {
		return this.produto;
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
}
