package br.uefs.ecomp.siscareta.model;

public class Camarote extends Evento {

	private static Integer num = 0;
	private Integer iD;
	
	public Camarote(String nomeCamarote, Pessoa responsavel) {
		super(nomeCamarote, responsavel);
		this.num++;
		this.iD = num;
	}

	
	public Integer getiD() {
		return iD;
	}


	public void setiD(Integer iD) {
		this.iD = iD;
	}


	@Override
	public String toString() {
		return "\nCamarote: " + getNome() + "\nResponsavel :" + getResponsavel().toString();
	}
	
	
	
}
