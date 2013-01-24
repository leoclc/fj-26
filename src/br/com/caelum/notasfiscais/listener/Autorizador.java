package br.com.caelum.notasfiscais.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.caelum.notasfiscais.mb.LoginBean;

public class Autorizador implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext cxt = event.getFacesContext();
		if ("/login.xhtml".equals(cxt.getViewRoot().getViewId()))
			return;

		LoginBean loginBean = cxt.getApplication().evaluateExpressionGet(cxt,
				"#{loginBean}", LoginBean.class);

		if (!loginBean.isLogado()) {
			NavigationHandler handler = cxt.getApplication()
					.getNavigationHandler();
			handler.handleNavigation(cxt, null, "login?faces-redirect=true");

			cxt.renderResponse();
		}
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
