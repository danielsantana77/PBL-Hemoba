package br.uefs.ecomp.siscareta.util;


public class Fila implements IFila{
	
	private Celula primeiro;
	private Celula ultimo;
	private int totElementos;
	
	public Fila() {
		this.primeiro = null;
		this.ultimo = null;
		this.totElementos = 0;
	}

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
	
	
		@Override
		public boolean estaVazia() {
			return this.totElementos == 0;
		}
	
		@Override
		public int obterTamanho() {
			return this.totElementos;
		}
	
		@Override
		public void inserirFinal(Object dado) {
			
			
			Celula nova = new Celula(dado);
			if(estaVazia()){
				primeiro = nova;
				ultimo = nova;
			}else{
				ultimo.setProximo(nova);
				ultimo = nova;
			}
			this.totElementos++;
			
			
		}
	
		@Override
		public Object removerInicio() {
			Object ret = null;
			if(!estaVazia()){
				
				ret = primeiro.getDado();
				
				if(primeiro == ultimo){
					primeiro = ultimo = null;
				}else{
				
					primeiro = primeiro.getProximo();
				}
				totElementos--;
			}
			return ret;
		}
	
		@Override
		public Object recuperarInicio() {

			if(!estaVazia()){
				return primeiro.getDado();
			}else
				return null;
		
		}

}
