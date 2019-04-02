package br.uefs.ecomp.siscareta.controller;

import br.uefs.ecomp.siscareta.util.Iterador;
import br.uefs.ecomp.siscareta.util.Lista;
import br.uefs.ecomp.siscareta.model.Atracao;
import br.uefs.ecomp.siscareta.model.Cliente;

public class ControllerAtracao {

	static Lista listAtracao = new Lista();
	
	Atracao atracao;
	
	/*
	 *Metodo para inserir uma Atração na Lista de Atrações 
	 */

	public Atracao inserirAtracao(String nome){
		
		atracao = new Atracao(nome);
		listAtracao.inserirFinal(atracao);
		
		return atracao;
	}
	
	public Iterador listarAtracoes(){
		
		
		if(!listAtracao.estaVazia()){
			return listAtracao.iterador();
		}
		return null;
		
	}
	
	/*
	 *Metodo para remover uma Atracao da lista atraves do numero ID passado por parametro 
	 */

	public boolean excluirAtracao(Integer id){
		
		Iterador itrAtracao = listAtracao.iterador();
		Atracao aux = null;
		
		while(itrAtracao.temProximo()){
			aux = (Atracao) itrAtracao.obterProximo();
			if(aux.getiD() == id){
				listAtracao.buscaRemove(aux);
				return true;
			}
				
			
		}
		
		return false;
		
	}
	
	/*
	 *Retorna um Objeto do tipo Atracao , atraves do ID 
	 */

	
	public Atracao obterAtracao(Integer id){
		
		
		Iterador itrAtracao = listAtracao.iterador();
		Atracao aux;
		
		while(itrAtracao.temProximo()){
			aux = (Atracao) itrAtracao.obterProximo();
			if(aux.getiD() == id){
				return aux;
			}
		}
		
		return null;
		
		
	}
	
}
