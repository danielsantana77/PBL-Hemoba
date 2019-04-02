package br.uefs.ecomp.siscareta.model;

import java.time.LocalDate;

public class Vendas {
	
	private Cliente cliente;
	private Vendedor vendedor;;
	private Apresentacao apr;
	private static Integer num = 0;
	private Integer id;
	private LocalDate dia;
	private Integer camisasV;
	
	
	public Vendas(Cliente cliente, Vendedor vendedor, Apresentacao apr,Integer camisasV,LocalDate dia) {
		
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.apr = apr;
		this.num++;
		id = num;
		this.camisasV = camisasV;
		this.dia = dia;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	public Apresentacao getApr() {
		return apr;
	}


	public void setApr(Apresentacao apr) {
		this.apr = apr;
	}


	public Integer getCamisasV() {
		return camisasV;
	}


	public void setCamisasV(Integer camisasV) {
		this.camisasV = camisasV;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDia() {
		return dia;
	}


	public void setDia(LocalDate dia) {
		this.dia = dia;
	}
	
	
	
	
}
