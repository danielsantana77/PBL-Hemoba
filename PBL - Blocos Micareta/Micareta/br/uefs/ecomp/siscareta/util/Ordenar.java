package br.uefs.ecomp.siscareta.util;

import java.util.Arrays;
import br.uefs.ecomp.siscareta.model.*;

public class Ordenar{
	
	
	public static void ordenarQuick(Pessoa [] vetor,int esquerda, int direita) {
		
		if(esquerda >= direita ){
			return;
		}
		Pessoa pivo = vetor[(esquerda + direita) / 2];
		int posicao = separar(vetor, esquerda, direita, pivo);
		ordenarQuick(vetor,esquerda, posicao - 1);
		ordenarQuick(vetor,posicao, direita);
		
	}

	private static int separar(Pessoa [] vetor, int esquerda, int direita, Pessoa pivo) {
		
		while(esquerda <= direita){
				
				while(vetor[esquerda].getNome().compareTo(pivo.getNome()) < 0){
					esquerda++;
				}
				
				while(vetor[direita].getNome().compareTo(pivo.getNome()) > 0){
					direita--;
				}
				
				if(esquerda <= direita){
					swap(vetor,esquerda,direita);
					esquerda ++;
					direita--;
				}
		}
		return esquerda;
		
		
	}

	private static void swap(Pessoa[] vetor, int esquerda, int direita) {
		
		Pessoa temp;
		temp = vetor[esquerda];
		vetor[esquerda] = vetor[direita];
		vetor[direita] = temp;
		
		
	}


	
	
	
	
}
