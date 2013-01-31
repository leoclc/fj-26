package br.com.caelum.notasfiscais.datamodel;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.interceptor.Transactional;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

public class DataModelNotasFiscais extends LazyDataModel<NotaFiscal> {
	/**
	 * 
	 */
	@Inject
	private DAO<NotaFiscal> dao;
	@Inject
	private EntityManager em;
	private static final long serialVersionUID = 1L;

	@Transactional
	public List<NotaFiscal> load(int inicio, int quantidade,
			String campoOrdenacao, SortOrder sentidoOrdenacao,
			Map<String, String> filtros) {
		return dao.listaTodosPaginada(inicio, quantidade);
	}
}
