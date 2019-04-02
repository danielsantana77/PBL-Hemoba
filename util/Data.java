package br.uefs.ecomp.hemoba.main.util;

/* Essa Classe Data que contem os atributos dia , mes, ano e hora privados
 * fazendo parte das classes Doacao e Doador com funçao de determinar
 * o data e o horario.
 */

public class Data {
    private int dia;
    private int mes;
    private int ano;
   
    
    
    public Data() {
		
		
	}

	public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


	@Override
	public String toString() {
		return " Dia=" + dia + ", Mes=" + mes + ", Ano=" + ano;
	}
    
    
    
}
