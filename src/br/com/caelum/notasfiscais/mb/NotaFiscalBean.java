package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;
@ViewScoped
@ManagedBean
public class NotaFiscalBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Item item = new Item();
	private NotaFiscal notaFiscal = new NotaFiscal();
	private long idProduto;

	public void guardaItem(){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		Produto produto = dao.buscaPorId(getIdProduto());
		getItem().setProduto(produto);
		getItem().setValorUnitario(produto.getPreco());
		getNotaFiscal().getItens().add(getItem());
		setItem(new Item());
	}
	
	
	public void gravar() {
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		dao.adiciona(getNotaFiscal());

		this.setNotaFiscal(new NotaFiscal());
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}


	public long getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}


	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}
}
