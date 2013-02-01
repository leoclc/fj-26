package br.com.caelum.notasfiscais.listener;

import javax.enterprise.event.Observes;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import org.jboss.seam.faces.event.qualifier.After;
import org.jboss.seam.faces.event.qualifier.RestoreView;

import br.com.caelum.notasfiscais.modelo.UsuarioLogado;

public class Autorizador implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private UsuarioLogado logado;
	@Inject
	private NavigationHandler nav;
	@Inject
	private FacesContext ctx;
	@Override
	public void afterPhase(PhaseEvent event) {
	}

	public void autoriza(@Observes @After @RestoreView PhaseEvent event) {
		String viewId = ctx.getViewRoot().getViewId();
		if (!"/login.xhtml".equals(viewId) && !logado.isLogado()){
			logado.setLastURL(viewId + "?faces-redirect=true");
		nav.handleNavigation(ctx, null, "login.xhtml?faces-redirect=true");
		ctx.renderResponse();
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
