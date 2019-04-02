package br.uefs.ecomp.hemoba.main.model;

public class Posto {
    private int numeroP;
    private String endereco;
    private String telefone;
    private String responsavel;

    public Posto(String endereco, String telefone, String responsavel, Integer numeroP) {
        this.endereco = endereco;
        this.telefone = telefone;
        this.responsavel = responsavel;
        this.numeroP = numeroP;
    }

    public Posto() {
    }

    
    
    public int getNumeroP() {
        return numeroP;
    }

    public void setNumeroP(Integer numeroP) {
        this.numeroP = numeroP;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Posto{" + "numeroP=" + numeroP + ", endereco=" + endereco + ", telefone=" + telefone + ", responsavel=" + responsavel + '}';
    }
   
    
    
}
