package br.com.caelum.notasfiscais.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class CicloDeVidaListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent arg0) {
		System.out.println("Antes da fase");
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		System.out.println("Depois da fase");
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
	
}
