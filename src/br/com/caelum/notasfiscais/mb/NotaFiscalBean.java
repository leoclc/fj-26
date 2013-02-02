package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.event.FlowEvent;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.interceptor.Transactional;
import br.com.caelum.notasfiscais.modelo.Estado;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.utils.UserWizard;
@ViewScoped
@Named
public class NotaFiscalBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> cidades = new ArrayList<>();
	private Item item = new Item();
	private NotaFiscal notaFiscal = new NotaFiscal();
	private long idProduto;
	@Inject
	private EntityManager em;
	@Inject
	private DAO<NotaFiscal> notaFiscalDAO;
	@Inject
	private DAO<Produto> produtoDAO;
	private boolean skip;
	
	private static Logger logger = Logger.getLogger(UserWizard.class.getName());
	
	
	
	@Transactional
	public void guardaItem(){
		Produto produto = produtoDAO.buscaPorId(getIdProduto());
		getItem().setProduto(produto);
		getItem().setValorUnitario(produto.getPreco());
		getNotaFiscal().getItens().add(getItem());
		setItem(new Item());
	}
	public void mudaEstado(ValueChangeEvent value){
		Estado estado =	(Estado) value.getNewValue();
		this.cidades = estado.getCidades();
	}

	public Estado[] getEstados(){
		return Estado.values();
	}
	@Transactional
	public void gravar() {
		notaFiscalDAO.adiciona(getNotaFiscal());
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
	
	public List<String> getCidades() {
		return cidades;
	}

	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}
	

	public void save(ActionEvent actionEvent) {
		//Persist user
		
		FacesMessage msg = new FacesMessage("Successful", "Welcome :");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	
	public String onFlowProcess(FlowEvent event) {
		logger.info("Current wizard step:" + event.getOldStep());
		logger.info("Next step:" + event.getNewStep());
		
		if(skip) {
			skip = false;	//reset in case user goes back
			return "confirm";
		}
		else {
			return event.getNewStep();
		}
	}
	
	
	
	
	
	
	
}
