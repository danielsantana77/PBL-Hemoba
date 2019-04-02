package br.uefs.ecomp.siscareta.controller;

import br.uefs.ecomp.siscareta.model.*;
import br.uefs.ecomp.siscareta.util.*;

public class ControllerPessoa {
		
	
		static Lista listCliente = new Lista();
		static Lista listVendedor = new Lista();
		
	
		Cliente cliente;
		Pessoa pessoa;
		Vendedor vendedor;
	
		Iterador itrCliente;
		Iterador itrVendedor;;
	
	public Cliente inserirCliente(Pessoa pes){
		
		cliente  = new Cliente(pes.getNome(),pes.getEmail(),pes.getCpf(),pes.getEndereco(),pes.getTelefone());
		listCliente.inserirFinal(cliente);
		
		return cliente;
	}
	
	public Vendedor inserirVendedor(Pessoa pes, double salario){
		
		vendedor = new Vendedor(pes.getNome(),pes.getEmail(),pes.getCpf(),pes.getEndereco(),pes.getTelefone(),salario);
		listVendedor.inserirFinal(vendedor);
		
		return vendedor;
		
	}
	
	public Cliente obterCliente(String cpf){
		
		itrCliente = listCliente.iterador();
		Cliente aux;
		
		while(itrCliente.temProximo()){
			aux = (Cliente) itrCliente.obterProximo();
			if(aux.getCpf().equals(cpf)){
				return aux;
			}
		}
		
		return null;
		
	}
	
	public Vendedor obterVendedor(String cpf){
		
		itrVendedor = listVendedor.iterador();
		Vendedor aux;
		
		while(itrVendedor.temProximo()){
			aux = (Vendedor) itrVendedor.obterProximo();
			if(aux.getCpf().equals(cpf)){
				return aux;
			}
		}
		
		return null;
	}
	
	
	public Iterador listarClientes(){
		if(!listCliente.estaVazia()){
			return listCliente.iterador();
		}
		return null;
		
	}
	
	public Iterador listarVendedor(){
		if(!listVendedor.estaVazia()){
			return listVendedor.iterador();
		}
		return null;
		
	}
	
	
	
	public boolean excluirCliente(String cpf){
		Iterador itr = listCliente.iterador();
		Cliente aux = null;
		
		while(itr.temProximo()){
			aux = (Cliente) itr.obterProximo();
			if(aux.getCpf().equals(cpf)){
				listCliente.buscaRemove(aux);
				return true;
			}
			
		}
		return false;
	}
	
	public boolean excluirVendedor(String cpf){
		Iterador itr = listVendedor.iterador();
		Vendedor aux = null;
		
		while(itr.temProximo()){
			aux = (Vendedor) itr.obterProximo();
			if(aux.getCpf().equals(cpf)){
				listVendedor.buscaRemove(aux);
				return true;
			}
			
		}
		
		return false;
		
	}
	
	/*
	 * Verifica na Lista de Pessoas e Responsaveis, se determinado CPF exista
	 * caso exista retorna um booleano falso, senao retorna verdadeiro
	 */

	
	public boolean verificarCpf(String cpf,Lista listBloco,Lista listCamarote){
		
		Iterador itrV = listVendedor.iterador();
		
		while(itrV.temProximo()){
			Vendedor aux = (Vendedor) itrV.obterProximo();
			if(aux.getCpf().compareTo(cpf)==0){
				return false;
			}
			
		}
		
		Iterador itrC = listCliente.iterador();
		
		while(itrC.temProximo()){
			Cliente aux = (Cliente) itrC.obterProximo();
			if(aux.getCpf().compareTo(cpf) == 0){
				return false;
			}
		}
		
		Iterador itrBloco =  listBloco.iterador();
		while(itrBloco.temProximo()){
			Bloco aux = (Bloco) itrBloco.obterProximo();
			if(aux.getResponsavel().getCpf().compareTo(cpf) == 0){
				return false;
			}
			
		}
		
		Iterador itrCamarote = listCamarote.iterador();
		while(itrCamarote.temProximo()){
			Camarote aux = (Camarote) itrCamarote.obterProximo();
			if(aux.getResponsavel().getCpf().compareTo(cpf) == 0){
				return false;
			}
			
		}
		return true;
	}
	
	/*
	 *Metodos que ordenam um vetor de Objetos Pessoa pelo nome,
	 *passando os objetos da Lista Pessoa , e armazenando em um vetor  
	 */

	public Pessoa[] ordenarVendedor(){
		
		int tam = listVendedor.obterTamanho();
		Iterador itrV = listVendedor.iterador();
		
		Vendedor[] vetorV = new Vendedor[tam];
		
		for(int i = 0;i < vetorV.length;i++){
				vetorV[i] = ((Vendedor)itrV.obterProximo()); 
			
		}
		
		Ordenar ord = new Ordenar();
		
		ord.ordenarQuick(vetorV, 0, tam - 1);
		
		return vetorV;
		
		
	}
	
	
	public Pessoa[] ordenarClientes(){
		
		int tam = listCliente.obterTamanho();
		Iterador itrC = listCliente.iterador();
		
		Cliente[] vetorC = new Cliente[tam];
		
		for(int i = 0;i < vetorC.length; i++){
			vetorC[i] = ((Cliente)itrC.obterProximo());
		}
		
		Ordenar ord = new Ordenar();
		ord.ordenarQuick(vetorC, 0, tam - 1);
		
		return vetorC;
	}

	
}
