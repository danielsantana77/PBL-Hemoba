package br.uefs.ecomp.hemoba.main.model;

import br.uefs.ecomp.hemoba.main.util.Data;;

/*Classe Doador que contem metodos e atributos relacionados ao mesmo
 * 
 */

public class Doador {
    private String nome, responsavelDoador,documento;
    private String endereco;
    private String telefone;
    private Data data;
    private double peso;
    private int matricula;
    
    public Doador() {
    	
    }
    
    public Doador(String nome, String responsavelDoador, String documento, String endereco, String telefone,Data dataNasc, double peso, int matricula) {
        this.nome = nome;
        this.responsavelDoador = responsavelDoador;
        this.documento = documento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.data = dataNasc;
        this.peso = peso;
        this.matricula = matricula;
    }
    
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {        
        this.nome = nome;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "\n\nDoador :" + "Nome = " + nome + "\nResponsavel do Doador = " + responsavelDoador + "\nDocumento = " + documento + "\nEndereco = " + endereco + "\nTelefone=" + telefone + "\nData de Nascimento= " + data + "\nPeso = " + peso + "\nMatricula = " + matricula+"\n";
    }


    
    
    
    
    
}
