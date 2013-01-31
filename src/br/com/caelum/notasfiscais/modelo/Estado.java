package br.com.caelum.notasfiscais.modelo;

import java.util.Arrays;
import java.util.List;

public enum Estado {
	AL(),
	AP(),
	AM(),
	BA(),
	CE(),
	DF(),
	ES(),
	GO(),
	MA(),
	MT(),
	MS(),
	MG("Diamantina","Belo Horizonte","Ouro Fino"),
	PR(),
	PB(),
	PA(),
	PE(),
	PI(),
	RJ("Rio","Bangu","Niteroi"),
	RN(),
	RS(),
	RO(),
	RR(),
	SC(),
	SE(),
	SP("Sao Paulo","Itu"),
	TO();

	
	private List<String> cidades;
	
	public List<String> getCidades() {
		return cidades;
	}

	private Estado(String... nomeCidade) {
		cidades = Arrays.asList(nomeCidade);
	}
}
