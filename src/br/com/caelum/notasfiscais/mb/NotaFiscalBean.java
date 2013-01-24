package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@ManagedBean
public class NotaFiscalBean {
	private NotaFiscal notaFiscal = new NotaFiscal();

	public void gravar() {
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		dao.adiciona(notaFiscal);

		this.notaFiscal = new NotaFiscal();
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
}
