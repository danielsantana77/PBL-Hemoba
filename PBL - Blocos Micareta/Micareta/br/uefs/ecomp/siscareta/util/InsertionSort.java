package br.uefs.ecomp.siscareta.util;

public class InsertionSort {
	
	public int[] ordenar(int[] vetor){
		
		for(int i = 1; i <vetor.length; i++){
			int j = i;
			while(j> 0 && vetor[j] < vetor[j-1]){
				swap(vetor,j,j-1);
				j--;
			}
		}
		
	return vetor;
	}
	private static void swap(int[] vetor, int esquerda, int direita) {
		
		int temp;
		temp = vetor[esquerda];
		vetor[esquerda] = vetor[direita];
		vetor[direita] = temp;
		
		
	}
}
