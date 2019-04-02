package br.uefs.ecomp.siscareta.model;

public class Evento {
	
	private String nome;
	private Pessoa responsavel;
	

	public Evento(String nome, Pessoa responsavel) {
		this.nome = nome;
		this.responsavel = responsavel;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Pessoa getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(Pessoa responsavel) {
		this.responsavel = responsavel;
	}
	
	

}
