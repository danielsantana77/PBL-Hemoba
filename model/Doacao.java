package br.uefs.ecomp.hemoba.main.model;

import br.uefs.ecomp.hemoba.main.util.Data;

public class Doacao {
    private Data dataD;
    private int hora;
    private int numeroPosto;
    private int matriculaDoador;
    private boolean status;

    // Construtor da Classe , que recebera¡ os Dados do Doador por Parametro
    public Doacao(Data dataD, int hora, int numeroPosto, int matriculaDoador, boolean status) {
        this.dataD = dataD;
        this.hora = hora;
        this.numeroPosto = numeroPosto;
        this.matriculaDoador = matriculaDoador;
        this.status = status;
    }
   
    // Metodos Acessores e Modificadores
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getNumeroPosto() {
        return numeroPosto;
    }

    public void setNumeroPosto(int numeroP) {
        this.numeroPosto = numeroP;
    }

    public int getMatriculaD() {
        return matriculaDoador;
    }

    public void setMatriculaD(int matriculaD) {
        this.matriculaDoador = matriculaD;
    }

    public boolean isStatus() {
    	
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

	public Data getDataD() {
		return dataD;
	}

	public void setDataD(Data dataD) {
		this.dataD = dataD;
	}

	@Override
	public String toString() {
		return "\nDoacao:  \nData da Doacao=" + dataD +"\nHorario da Doacao : " +hora +"\nNumero do Posto = " + numeroPosto + "\nMatricula do Doador = "
				+ matriculaDoador + "\nStatus = " + ((status)?"Realizado":"Nao Realizado\n");
	}
    
    
    
}
