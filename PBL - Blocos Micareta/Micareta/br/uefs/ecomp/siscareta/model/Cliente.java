package br.uefs.ecomp.siscareta.model;

public class Cliente extends Pessoa{

	private Integer id;
	private static Integer num = 0;
	
	public Cliente(String nome, String email, String cpf, String endereco, Integer telefone) {
		super(nome, email, cpf, endereco, telefone);
		this.num++;
		this.id=num;
		
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "\nCliente = " + getNome() + "\nEmail = " + getEmail() + "\nCpf = " + getCpf()
				+ "\nEndereco = " + getEndereco() + "\nTelefone = " + getTelefone();
	}
	
	
	
	
}
