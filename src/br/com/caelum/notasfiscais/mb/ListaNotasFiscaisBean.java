package br.com.caelum.notasfiscais.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
@ViewScoped
@ManagedBean
public class ListaNotasFiscaisBean {
	
	private List<NotaFiscal> notas = new ArrayList<NotaFiscal>();

	public List<NotaFiscal> getNotas() {
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		this.notas = dao.listaTodos();
		return notas;
	}

	public void setNotas(List<NotaFiscal> notas) {
		this.notas = notas;
	}
	
	
}
