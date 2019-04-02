package br.uefs.ecomp.siscareta.util;

import br.uefs.ecomp.siscareta.util.ILista;
import br.uefs.ecomp.siscareta.util.Iterador;

/*Classe Lista que implementa os metodos da interface ILista,
 * generica e, que contem atributos que referencia dados
 * do tipo Celula, sendo os elementos dessa Lista Encadeada e possui
 * um Iterador que ira percorrer a mesma; 
 */

public class Lista implements ILista{
	
    private Celula primeiro;
    private Celula ultimo;
    private int totElementos;
    
    public Lista() {
        primeiro = null;
        ultimo = null;
        this.totElementos = 0;
        
    }
    /*Classe Celula contida dentro da Classe Lista , com acesso Privado.
     * Possui um atributo do tipo Object e uma referencia para outro Objeto
     * do tipo Celula .
     * 
     */
    private class Celula {
        private Object dado;
        private Celula proximo;
        
        
        
        public Celula(Object dado) {
			this.dado = dado;
		}

		public Object getDado() {
            return dado;
        }

        public void setDado(Object dado) {
            this.dado = dado;
        }

        public Celula getProximo() {
            return proximo;
        }

        public void setProximo(Celula proximo) {
            this.proximo = proximo;
        }
        
    }
    
    public Celula getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Celula primeiro) {
        this.primeiro = primeiro;
    }

    public Celula getUltimo() {
        return ultimo;
    }

    public void setUltimo(Celula ultimo) {
        this.ultimo = ultimo;
    }

    public int getTotElementos() {
        return totElementos;
    }

    public void setTotElementos(int totElementos) {
        this.totElementos = totElementos;
    }
    
    /* Metodo getCelula que retorna um Objeto do tipo Celula
     * recebendo uma variavel primitiva inteiro relacionada
     * a posicao do Objeto na Lista.
     * 
     */
    
     private Celula getCelula(int posicao){
        
        if(posicao >= 0 && posicao <= obterTamanho()){
            Celula aux = this.primeiro;
            for(int i = 0;i < posicao; i++){
                aux = aux.getProximo();
            }
            return aux;
        }
        System.out.println("Elemento nao existe");
        return null;
    }
    
    /*Metodo buscaRemove . recebe um Object por parametro,
     * tem a funcao de percorrer uma lista , implementando
     * um indice e chamando um metodo que recebe o valor 
     * desse indice, ou seja, passa a posicao do objeto 
     * recebido, caso ele exista, senão retorna null
     * 
     */
    
    public void buscaRemove(Object dado){
       Celula aux = primeiro;
       for(int i = 0; aux != null;i++){
    	   if(aux.getDado() != null && aux.getDado().equals(dado)){
    		   remover(i);
    		   return;
    	   }
    	   aux = aux.getProximo();
       }
        
    }
    
    /*Metodo chamado dentro do metodo buscaRemove, tem a funcao
     * de encontrar e remover determinado objeto pelo valor da posicao 
     * recebida por parametro 
     * 
     */
    public void remover(int posicao){
    	
    	if(posicao==0){
    		this.removerInicio();
    		
    	}else if (posicao == this.obterTamanho() - 1){
    		this.removerFinal();
    	
    	}	else if(posicao > 0 && posicao <= this.obterTamanho() - 1){
    	
    		Celula anterior = getCelula(posicao - 1);
    		Celula aux = anterior.getProximo();
    		anterior.setProximo(aux.getProximo());
    	}
    	
    }
    
    /*Metodo que verifica se a Lista está vazia
     */
    
    @Override
    public boolean estaVazia() {
        return (primeiro == null);
        
    }
    
    /*Metodo que retorna a quantidade de elementos na Lista
     */
    
    @Override
    public int obterTamanho() {
        return this.getTotElementos();
        
    }
    
    /*Metodo com funcao de inserir o Objeto no inicio da lista,
     * tornando esse novo objeto ser o primeiro elemento da Lista
     * 
     */
    
    @Override
    public void inserirInicio(Object dado) {
    	
        Celula novo = new Celula(dado);
    
        if(primeiro == null && ultimo == null){
            primeiro = novo;
            ultimo= novo;                               
        }else{
            novo.setProximo(primeiro);
            primeiro = novo;
            
        }
        this.totElementos++;
    }
    
    /*Metodo com a funcao de inserir um objeto no final da lista
     * apenas fezendo o ultimo elemento apontar para o novo objeto.
     */
    
    @Override
    public void inserirFinal(Object dado) {
         
        Celula novo = new Celula(dado);
        if(primeiro == null && ultimo == null){
           primeiro = novo;
           ultimo = novo;
        }else{
            ultimo.setProximo(novo);
            ultimo = novo;
            
        }
        this.totElementos++;
    }
    
    /*Metodo com a funcao de remover um objeto no inicio da lista;
     */

    @Override
    public Object removerInicio() {
        
    	if(primeiro == ultimo){
    		primeiro = ultimo = null;
    		this.totElementos--;
    		return null;
    	}
        this.primeiro = primeiro.getProximo();
        this.totElementos--;        
        return primeiro;
    }

    /*Metodo com a funcao de remover um objeto no final da lista
     * 
     */
    
    @Override
    public Object removerFinal() {
     
    	Celula aux = primeiro;
        Celula anterior = primeiro;
        
        while(aux.getProximo() != null){
            anterior=aux;
            aux=aux.getProximo();
        }
        anterior.setProximo(null);
        this.ultimo= anterior;
        this.totElementos--;
        return null;
        
    }
    
    /*Metodo com funcao de retonar um objeto,caso exista, em 
     * determinada posicao.
     * 
     */
    
    @Override    
    public Object recuperar(int index) {
        Celula aux = getCelula(index);
        if(aux != null){
            return aux.getDado();
        }
        
        return null;
    }
    
    /*Metodo Iterador, que retorna um objeto do tipo iterador
     * com funcao de percorrer uma Lista.
     */
    
    @Override
    public Iterador iterador() {
        return new ListIterator();
        
    }
    
    private class ListIterator implements Iterador{
        private int atual = 0;
        
        /*Metodo com funcao de verificar se na Lista há um proximo elemento
         * retornando um false ou true.
         */
        
        @Override
        public boolean temProximo() {
            return getCelula(atual) != null;
        }
        
        /*Metodo do Iterador que retorna um objeto da posicao atual
         * 
         */

        @Override
        public Object obterProximo() {
        	
            Object aux = recuperar(atual);
            atual++;          
            return aux;
        }
        
    }
}
    