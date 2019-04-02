package br.uefs.ecomp.siscareta.controller;

import br.uefs.ecomp.siscareta.util.*;

import java.time.LocalDate;

import br.uefs.ecomp.siscareta.model.*;


public class ControllerApresentacao {
	
	static Lista listAP = new Lista();
	static Lista listVendas = new Lista();
	static Fila filaEspera = new Fila();
	
	/*
	 *Insere um Objeto do tipo Apresentação com associaçao Atracao/Bloco na Lista 
	 */

	public boolean inserirApresentacao(Atracao atracao, Evento evento, LocalDate[] dataA,Integer numCamisas){
		
		Apresentacao ap = new Apresentacao(evento,atracao,dataA,numCamisas);
		
		listAP.inserirFinal(ap);
		
		return true;
	}
	
	/*
	 *Insere uma Apresentacao com Associaçao Atraçao/Camarote 
	 */

	public boolean inserirApresentacao(Atracao atracao,Evento evento, Integer numCamisas){
		
		Apresentacao ap = new Apresentacao(evento,atracao,numCamisas);
		
		listAP.inserirFinal(ap);
		
		return true;
		
	}
	
	public Iterador listarAP(){
		
		if(!listAP.estaVazia()){
			return listAP.iterador();
		}
		
		return null;
	}
	
	/*
	 *Excluir uma apresentaçao atraves de seu ID 
	 */

	public boolean excluirApresentacao(Integer num){
		
		Iterador itrA = listAP.iterador();
		
		Apresentacao apr = null;
		
		while(itrA.temProximo()){
			apr = (Apresentacao) itrA.obterProximo();
			if(apr.getAtracao().getiD() == num){
				listAP.buscaRemove(apr);
				return true; 
			}
			
			
		}
		
		return false;
		
	}
	
	public Apresentacao obterApresentacao(Integer id){
		
		Iterador itrA = listAP.iterador();
		Apresentacao apr = null;
		
		while(itrA.temProximo()){
			apr = (Apresentacao) itrA.obterProximo();
			if(apr.getAtracao().getiD() == id){
				return apr; 
			}
			
			
		}
		return null;
	}
	
	/*
	 *Insere um objeto do Tipo Venda na Lista 
	 */

	public boolean inserirVendas(Cliente cliente, Vendedor vendedor, Apresentacao apr,Integer camisasV,LocalDate dia){
		
		Iterador itrV = listVendas.iterador();
		
		if(itrV != null && !verificarVendas(dia,apr)){
			return false;
			
		}
		
		Vendas vend = new Vendas(cliente,vendedor,apr,camisasV,dia);
		apr.venderCamisas(camisasV);
		listVendas.inserirFinal(vend);
		
		return true;
	}
		
	public Vendas obterVendas(Integer id){
		
		Iterador itrV = listVendas.iterador();
		Vendas aux = null;
		
		while(itrV.temProximo()){
			aux = (Vendas) itrV.obterProximo();
			if(aux.getId() == id){
				return aux;
			}
		}
		return aux;
		
	}
	
	public Iterador listarVendas(){
		
		if(!listVendas.estaVazia()){
			return listVendas.iterador();
		}
		
		return null;
	}
	
	/*
	 *Verifica se o numero de camisas Recebido por Parametro é menor
	 *que o numero de Camisas Restantes contidos na Apresentação 
	 */

	public boolean compararQtCamisas(Integer camisas,Apresentacao apr){
		
		if(apr.camisasRestantes() < camisas){
			
			return true;
		}
		return false;
		
	}

	/*
	 *Verifica se o numero de Camisa é o correto 
	 */

	public boolean verificarNumCamisas(Integer numCamisas) {
		
		if(numCamisas <= 4 && numCamisas >= 1){
			return true;
			
		}
		
		return false;
		
	}
	/*
	 *Retorna a quantidade de Camisas restantes contida na Apresentação
	 *passada por parametro 
	 */

	public Integer camisasRestantes(Apresentacao apr){
		
		return apr.camisasRestantes();
		
		
	}
	/*
	 *Insere uma Venda na Fila, caso o numero de camisas da Apresentacao esteja esgotado
	 *caso o cliente queira um numero maior de camisas do que restam, é esse subtraido a
	 *quantidade que ele quer pelas restantes e a venda é inserida na fila com a camisa que sobrou
	 *dessa subtração 
	 */

	public void inserirFila(Cliente cliente, Vendedor vendedor, Apresentacao apr,Integer camisasV,LocalDate dia){
		
		camisasV = camisasV - apr.camisasRestantes();
		apr.venderCamisas(apr.camisasRestantes());
		Vendas vend = new Vendas(cliente,vendedor,apr,camisasV,dia);
		filaEspera.inserirFinal(vend);
		
	}
	
	/*
	 *Verifica se o dia passado por parametro esta cadastrado na Apresentacão 
	 */

	public boolean verificarDiaCadastrado(LocalDate dia,Apresentacao apr){
		
		boolean diaCad = false;

		int i = 0;
		LocalDate[] diaAP = apr.getDataA();
		
		while(i < diaAP.length){
			
			if(diaAP[i++].equals(dia)){
				diaCad = true;
			}
		}
		
		return diaCad;
			
	}
	
	/*
	 * Verifica se o dia esta no intervalo
	 */

	public boolean verificarDia(Integer diaV) {
		
		
		if(diaV < 18 || diaV > 22){
			return false;
		}
		
		return true;
	}
	
	/*
	 *verifica se o dia existe na Venda 
	 */

	public static boolean verificarVendas(LocalDate dia,Apresentacao apr){
		
		Iterador itrV = listVendas.iterador();
		Vendas aux;
		
		while(itrV.temProximo()){
			aux= (Vendas) itrV.obterProximo();{
				if(aux.getDia().equals(dia) && aux.getApr().equals(apr)){
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	/*
	 * Verifica percorrendo a Lista de Apresentaçoes se uma Atraçao está inserida
	 * em uma Apresentação
	 */

	
	public boolean verificarAtracao(Integer id){
		
		Iterador itrAP = listAP.iterador();
		
		if(itrAP == null){
			return false;
		}
		Apresentacao apr;
		
		while(itrAP.temProximo()){
			apr = (Apresentacao) itrAP.obterProximo();
			if(apr.getAtracao().getiD() == id){
				return true;
			}
			
			
		}
		
		return false;
	}
	
	/*
	 *Verifica se o bloco existe na Lista de Apresentaçoes 
	 */

	public boolean verificarBloco(Bloco blo){
		
		Iterador itrAP = listAP.iterador();
		
		if(itrAP == null){
			return false;
		}
		Apresentacao apr;
		
		while(itrAP.temProximo()){
			apr = (Apresentacao) itrAP.obterProximo();
			if(apr.getEvento().equals(blo)){
				return true;
			}
			
			
		}
		
		return false;
	}
	/*
	 *Verifica se o Camarote existe na Lista de Apresentações 
	 */

	public boolean verificarCamarote(Camarote cam){
		
		Iterador itrAP = listAP.iterador();
		
		if(itrAP == null){
			return false;
		}
		Apresentacao apr;
		
		while(itrAP.temProximo()){
			apr = (Apresentacao) itrAP.obterProximo();
			if(apr.getEvento().equals(cam)){
				return true;
			}
			
			
		}
		
		return false;
	}
	
	/*
	 * Verifica se a Apresentacao passada por parametro existe em Vendas
	 */

	public boolean verificarApresentacaoEmVenda(Apresentacao apr){
		
		Iterador itrV = listVendas.iterador();
		
		if(itrV==null){
			
			return false;
		}
		
		Vendas vend;
		
		while(itrV.temProximo()){
			vend = (Vendas) itrV.obterProximo();
			if(vend.getApr().equals(apr)){
				return true;
			}
		}
		
		return false;
		
	}
	
	/*
	 *Adiciona camisas a Apresentaçao 
	 */

	public void adicionarCamisas(Apresentacao apr,Integer camisas){
		
		apr.adicionarCamisas(camisas);
		
	}
	
	/*
	 *Metodo com a funçao de verifica se existe Vendas na Lista de espera
	 *se houver camisas disponiveis, a Venda pode sair da fila ou manter
	 *caso o numero de camisas restantes nao seja o suficiente 
	 */

	
	public void verificarListadeEspera(Apresentacao apr) {
		
		
		Vendas vend = (Vendas) filaEspera.recuperarInicio();
		
		if(vend.getApr().equals(apr)){
			
			if(vend.getCamisasV() <= (apr.camisasRestantes())){
				sairDaFila(vend,apr);
			}else if(vend.getCamisasV() > apr.camisasRestantes()){
				manterNaFila(vend,apr);
			}
			
		}else{
			Fila aux = new Fila() ;
			
			for(int i = 0; i < filaEspera.obterTamanho() - 1;i++){
				
				vend = (Vendas) filaEspera.recuperarInicio();
				
				if(vend.getCamisasV() <= (apr.camisasRestantes())){
					sairDaFila(vend,apr);
					break;
				}else if(vend.getCamisasV() > apr.camisasRestantes()){
					manterNaFila(vend,apr);
				}
				aux.inserirFinal(filaEspera.removerInicio());//recebe o primeiro da fila
			}
			
			filaEspera = aux;
		}
	}
	
	public void manterNaFila(Vendas vend, Apresentacao apr) {
		
		Integer num = apr.camisasRestantes();
		vend.setCamisasV(vend.getCamisasV() - num);
		apr.venderCamisas(num);
	}

	public void sairDaFila(Vendas vend, Apresentacao apr){
		
		listVendas.inserirFinal(vend);
		apr.venderCamisas(vend.getCamisasV());
		filaEspera.removerInicio();
	}
	
	
}
