package br.uefs.ecomp.siscareta.model;

public class Vendedor extends Pessoa{

	private Integer matricula = 0;
	private static Integer iD = 0;
	private double salario;
	private static int num = 0;
	
	public Vendedor(String nome, String email, String cpf,
			String endereco, Integer telefone, double salario) {
		
		super(nome,email,cpf,endereco,telefone);
		this.num++;
		this.matricula = num;
		this.salario = salario;
		this.iD++;
		
	}
	
	

	public Integer getiD() {
		return iD;
	}



	public void setiD(Integer iD) {
		this.iD = iD;
	}



	public Integer getMatricula() {
		return matricula;
	}


	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	@Override
	public String toString() {
		return "Vendedor: "+ getNome() + "\nMatricula = " + matricula + "\nSalario = " + salario + "\nID = " + getiD()+ 
				 "\nEmail = " + getEmail() + "\nCPF = " + getCpf() + "\nEndereco = "
				+ getEndereco() + "\nTelefone = " + getTelefone() ;
	}

	
	
	
	
	
}
