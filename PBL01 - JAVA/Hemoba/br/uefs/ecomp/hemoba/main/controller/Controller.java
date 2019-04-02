package br.uefs.ecomp.hemoba.main.controller;
import br.uefs.ecomp.hemoba.main.model.Doacao;
import br.uefs.ecomp.hemoba.main.model.Doador;
import br.uefs.ecomp.hemoba.main.model.Posto;
import br.uefs.ecomp.hemoba.main.util.*;
import br.uefs.ecomp.hemoba.main.util.Lista;


/*Classe que controla todo o processo ,recebe os dados da View e 
 * passa para as classes do Model que retorna , e da autorizaçao
 * pra View mostrar esses Dados.
 */

	public class Controller {
	    
		static Lista listDoador = new Lista();
	    static Lista listPosto = new Lista();
	    static Lista listDoacoes = new Lista();
	    
	    Doador doador;
	    Posto posto;
	    Doacao doacao;
	    
	    public Controller() {
	       
	    }
	    
	    /*Metodo que recebe por parametros os dados do doador e insere
	     * no final da listDoador pelo metodo inserirFinal.
	     */
	    
	    public Doador cadastrarDoador(String nome, String endereco, String telefone, Data datanasc, double peso, 
	            String responsavelDoador, String documento, int matricula) {
	          
	        doador = new Doador(nome,responsavelDoador,documento, endereco, telefone,datanasc ,peso,matricula);
	        listDoador.inserirFinal(doador);
	          
	        return doador;
	    }
	    
	    /*Metodo obterDoador , recebe um valor por parametro, 
	     * tem a funcao de retornar Objeto do tipo Doador pelo 
	     * numero de matricula recebido.
	     */
	
	    public Doador obterDoador(int matricula) {
	    	
	    	Iterador itr = listDoador.iterador();
	    	Doador aux ;
	    	while(itr.temProximo()){
	    		aux=(Doador)itr.obterProximo();
	    		if(aux.getMatricula()== matricula){
	    			return aux;
	    		}
	    	}
	
	        return null;
	
	    }
	    
	    /*Metodo que recebe por parametros os dados do Posto e insere
	     * no final da listPosto pelo metodo inserirFinal.
	     */
	    public Posto cadastrarPosto(String endereco, String telefone , String responsavelPosto, int numeroPosto) {
	            posto = new Posto(endereco, telefone,responsavelPosto,numeroPosto);   
	            listPosto.inserirFinal(posto);
	            return posto;
	    }
	    
	    /*Metodo que retorna um objeto do tipo Posto,
	     * caso o encontre na lista atraves do numero do Posto
	     *  recebido por parametro.
	     */
	    
	    public Posto obterPosto(int numeroPosto) {
	        Iterador itr = listPosto.iterador();
	        Posto aux;
	        while(itr.temProximo()){
	        	aux=(Posto)itr.obterProximo();
	        	if(aux.getNumeroP() == numeroPosto){
	        		return aux;
	        	}
	        }
	        return null;
	
	    }
	    
	    /*Metodo que recebe por parametros os dados da doacai e insere
	     * no final da listDoacao pelo metodo inserirFinal.
	     */
		
	    public Doacao cadastrarDoacao(Data dataDoacao, int hora, int numeroPosto, int matricula, boolean status){
		    
			doacao = new Doacao(dataDoacao, hora, numeroPosto, matricula, status);
		    listDoacoes.inserirFinal(doacao);
		     
		    return doacao;
		}
	   
	    /*Metodos que retornam um Iterador para percorrer
	     *  uma Lista Encadeada ou retornam null caso esta Lista
	     *  esteja vazia;
	     * 
	     */
		public Iterador listarPostos() {
	      if(listPosto.estaVazia())
	        return null;
	      
	      return listPosto.iterador();
	    }
	
		
	    public Iterador listarDoadores() {
	    	
	    	if(listDoador.estaVazia())
	    		return null;
	    	
	    	return listDoador.iterador();
	    	
	    }
	
	    
	    public Iterador listarDoacoesDia() {
	    	if(listDoacoes.estaVazia()){
	    		return null;
	    	}
	        return listDoacoes.iterador();
	    }
	    
	    public Iterador listarDoacoesRealizadas(){
	    	if(listDoacoes.estaVazia()){
	    		return null;
	    	}
	        return listDoacoes.iterador();
	    }
	    
	    
	    public Iterador listarDoacoesNaoRealizadas(){
	    	if(listDoacoes.estaVazia()){
	    		return null;
	    	}
	        return listDoacoes.iterador();
	    }

	    
	    /*Metodos de Remocao de um elemento da Lista Encadeada,
	     * percorrem e comparam o valor recebido, caso encontrem,
	     * passam esse objeto para um metodo da Lista, onde será 
	     * removido.
	     */
	   
	    
	    public void excluirDoador(int mat) {
	    	Iterador itr = listDoador.iterador();
	    	Doador aux = null;
	    	
	    	while(itr.temProximo()){
	    		aux=(Doador)itr.obterProximo();
	    		if(aux.getMatricula() == mat){
	    			listDoador.buscaRemove(aux);
	    			return;
	    		}
	    	}
	    }
	    
	   
	    public void excluirDoacao(int matricula, int dia) {
	    	Iterador itr = listDoacoes.iterador();
	    	Doacao aux = null;
	    	while(itr.temProximo()){
	    		aux=(Doacao)itr.obterProximo();
	    		if(aux.getMatriculaD() == matricula  && aux.getDataD().getDia() == dia){
	    			listDoacoes.buscaRemove(aux);
	    			return;
	    		}
	    	}
	    }
	    
	    public void excluirPosto(int numP){
	       Iterador itr = listPosto.iterador();
	       Posto aux = null;
	       while(itr.temProximo()){
	    	   aux = (Posto) itr.obterProximo();
	    		if(aux.getNumeroP() == numP){
	    			listPosto.buscaRemove(aux);
	    			return;
	    		}
	       }
	   }
	   
	   
		}