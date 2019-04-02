package br.uefs.ecomp.siscareta.model;

public class Atracao {
	
	private Integer iD;
	static private Integer mat = 0;
	private String nome;
	
	public Atracao(String nome) {
		this.mat++;
		this.nome = nome;
		this.iD = mat;
	}
	
	public Integer getiD() {
		return iD;
	}
	public void setiD(Integer iD) {
		this.iD = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Nome Atracao : " +getNome()+ "\nID =" + iD;
	}
	
	
}
