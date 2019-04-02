package br.uefs.ecomp.siscareta.model;

import java.time.LocalDate;
import java.util.Arrays;

public class Bloco extends Evento{
	
	private Integer iD;
	private static Integer num = 0;
	private LocalDate[] dataB;
	
	
	public Bloco(String nomeBloco, Pessoa responsavel,LocalDate[] data) {
		super(nomeBloco, responsavel);
		this.num++;
		this.iD = num;
		this.dataB = data;
	
	}
	
	

	public static Integer getNum() {
		return num;
	}



	public static void setNum(Integer num) {
		Bloco.num = num;
	}


	
	public Integer getiD() {
		return iD;
	}



	public void setiD(Integer iD) {
		this.iD = iD;
	}


	public LocalDate[] getDataB() {
		return dataB;
	}



	public void setDataB(LocalDate[] dataB) {
		this.dataB = dataB;
	}


}
