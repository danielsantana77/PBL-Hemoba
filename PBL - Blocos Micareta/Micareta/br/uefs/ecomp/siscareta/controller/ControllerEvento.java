package br.uefs.ecomp.siscareta.controller;

import java.time.LocalDate;

import br.uefs.ecomp.siscareta.model.Bloco;
import br.uefs.ecomp.siscareta.model.Camarote;
import br.uefs.ecomp.siscareta.model.Pessoa;
import br.uefs.ecomp.siscareta.util.Iterador;
import br.uefs.ecomp.siscareta.util.Lista;
import br.uefs.ecomp.siscareta.util.*;

public class ControllerEvento {
	
	static Lista listBloco = new Lista();
	static Lista listCamarote = new Lista();
	
	Bloco bloco;
	Camarote camarote;
	
	
	
	Iterador itrCamarote;
	Iterador itrBloco;
	
	public Bloco inserirBloco(String nomeBloco, Pessoa responsavel,LocalDate[] datab){
		
		bloco = new Bloco(nomeBloco,responsavel,datab);
		listBloco.inserirFinal(bloco);
	
	
	return bloco;
	
	}
	
	public Camarote inserirCamarote(String nomeCamarote, Pessoa responsavel){
		
		camarote = new Camarote(nomeCamarote,responsavel);
		listCamarote.inserirFinal(camarote);
		
		return camarote;
		
	}
	
	public Camarote obterCamarote(Integer id){
		
		itrCamarote = listCamarote.iterador();
		
		while(itrCamarote.temProximo()){
			camarote = (Camarote) itrCamarote.obterProximo();
			if(camarote.getiD() == id){
				return camarote;
			}
			
		}
		
		return null;
		
	}
	
	public Bloco obterBloco(Integer id){
			
		itrBloco = listBloco.iterador();
			
		while(itrBloco.temProximo()){
			bloco = (Bloco) itrBloco.obterProximo();
			if(bloco.getiD() == id){
				return bloco;
			}
				
		}
			
		return null;
			
	}
	
	public Iterador listarCamarotes(){
		
		if(!listCamarote.estaVazia()){
			return listCamarote.iterador();
		}
		return null;
	}
	
	public Iterador listarBlocos(){
		
		if(!listBloco.estaVazia()){
			return listBloco.iterador();
		}
		
		return null;
	}
	
	
	public boolean excluirCamarote(Integer id){
		
		Iterador itr = listCamarote.iterador();
		Camarote aux = null;
		boolean excluiu = false;
		
		while(itr.temProximo()){
			aux = (Camarote) itr.obterProximo();
			if(aux.getiD() == id){
				listCamarote.buscaRemove(aux);
				return true;
			}
			
		}
		
		return excluiu;
	}
	
	
	
	public boolean excluirBloco(Integer iD){
		Iterador itr = listBloco.iterador();
		Bloco aux = null;
		boolean excluiu = false;
		
		while(itr.temProximo()){
			aux = (Bloco) itr.obterProximo();
			if(aux.getiD() == iD){
				listBloco.buscaRemove(aux);
				return true;
				
			}
			
		}
		return excluiu;	
			
	}
	/*
	 *Verifica se o dia esta no intervalo de dias do Micareta 
	 */

	
	public boolean verificarDia(int dia){
		
		if(dia >= 18 && dia <= 21){
		
			return true;
		}
		return false;
	}
	/*
	 *Verifica se os inteiros são iguais,pra não ocorrer dias iguais no Cadastro 
	 */

	public boolean verificarData(int dia1,int dia2){
		
		if(dia1 == dia2){
			return true;
		}
		return false;
		
		
	}
	
	/*
	 *Verifica se os Objetos LocalDate sao iguais 
	 */

	public boolean verificarData(LocalDate data, LocalDate aux){
		
		if(data.equals(aux)){
			return true;
		}
		return false;
	}
	
	/*
	 *Ordena um vetor de inteiros que serão os dias da Data em que os Eventos irão sair 
	 */

	public void ordenarData(int[] vetor){
		
		InsertionSort ordenarI = new InsertionSort();
		
		ordenarI.ordenar(vetor);
		
		
	}
	
	
	public Lista listaB(){
		return listBloco;
		
	}
	
	public Lista listaC(){
		return listCamarote;
	}
}
