package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
@ViewScoped
@Named
public class ListaNotasFiscaisBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private LazyDataModel<NotaFiscal> dataModel;
	@Inject
	private DAO<NotaFiscal> notaFiscalDAO;
	@Inject
	private EntityManager em;
	
	public ListaNotasFiscaisBean() {
	}
	
	@PostConstruct
	public void init(){
		this.dataModel.setRowCount(notaFiscalDAO.contaTodos());
		this.dataModel.setPageSize(5);
	}
	
	public LazyDataModel<NotaFiscal> getDataModel() {
	return this.dataModel;
	}

		
}
