package br.uefs.ecomp.siscareta.model;

public class Pessoa{

	private String nome;
	private String email;
	private String cpf;
	private String endereco;
	private Integer telefone;
	
	
	
	public Pessoa(String nome, String email, String cpf, String endereco, Integer telefone) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "\nNome =" + nome + "\nEmail = " + email + "\nCpf = " + cpf + "Endereco = " + endereco + "\nTelefone = "
				+ telefone;
	}

	
	
	
}
