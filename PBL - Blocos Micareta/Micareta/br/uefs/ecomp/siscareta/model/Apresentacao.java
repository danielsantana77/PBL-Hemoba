package br.uefs.ecomp.siscareta.model;

import java.time.LocalDate;
import java.util.Arrays;

public class Apresentacao {
	
	private static Integer num = 0;
	private int id;
	private Evento evento;
	private Atracao atracao;
	private LocalDate[] dataA;
	private Integer qtCamisas;
	private Integer qtCamisasVendidas = 0;
	
	public Apresentacao(Evento evento, Atracao atracao,LocalDate[] data,Integer qtCamisas) {
		
		this.evento = evento;
		this.atracao = atracao;
		this.dataA = data;
		this.qtCamisas = qtCamisas;
		this.id = ++this.num;
		
		
	}
	
	public Apresentacao(Evento evento, Atracao atracao,Integer qtCamisas) {
		
		this.evento = evento;
		this.atracao = atracao;
		this.qtCamisas = qtCamisas;
		this.id = ++this.num;
		
	}

	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}


	public Atracao getAtracao() {
		return atracao;
	}


	public void setAtracao(Atracao atracao) {
		this.atracao = atracao;
	}


	public LocalDate[] getDataA() {
		return dataA;
	}


	public void setDataA(LocalDate[] dataA) {
		this.dataA = dataA;
	}

	public Integer getQtCamisas() {
		return qtCamisas;
	}

	public void setQtCamisas(Integer qtCamisas) {
		this.qtCamisas = qtCamisas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getQtCamisasVendidas() {
		return qtCamisasVendidas;
	}

	public void setQtCamisasVendidas(Integer qtCamisasVendidas) {
		this.qtCamisasVendidas = qtCamisasVendidas;
	}
	
	
	public Integer camisasRestantes(){
		
		Integer aux = this.qtCamisas - this.qtCamisasVendidas;
		return aux;
	}
	
	
	public boolean venderCamisas(Integer camisas){
		
		if(this.qtCamisasVendidas <= this.qtCamisas){
			this.setQtCamisasVendidas(this.getQtCamisasVendidas() + camisas);
			return true;
		}
			return false;
	}
	
	public void adicionarCamisas(Integer camisas){
		
		this.qtCamisas += camisas;
		
	}

	public void adicionarCamisasDeVendasExcluidas(Integer camisas){
		
		this.qtCamisasVendidas -= camisas;
		
	}
	
	public String toString(){
	
		return "\nID Apresentacao : "+getId()+"\nEvento : "+getEvento().getNome()+"\nAtracao : "+getAtracao().getNome()
				+"\nDias na Avenida : "+Arrays.toString(getDataA())+"\nCamisas a Venda : "+getQtCamisas()+"\nCamisas Vendidas : "+this.getQtCamisasVendidas()
				+"\nCamisas restantes : "+ camisasRestantes();
		
		
	}
	
}
