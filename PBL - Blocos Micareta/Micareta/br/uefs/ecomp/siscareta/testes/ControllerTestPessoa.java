package br.uefs.ecomp.siscareta.testes;

import  org.junit.Before;

import  org.junit.*;


import br.uefs.ecomp.siscareta.controller.ControllerPessoa;
import br.uefs.ecomp.siscareta.model.Cliente;
import br.uefs.ecomp.siscareta.model.Pessoa;
import br.uefs.ecomp.siscareta.model.Vendedor;
import br.uefs.ecomp.siscareta.util.Iterador;
import junit.framework.TestCase;


public class ControllerTestPessoa extends TestCase{
		
		
	 private ControllerPessoa contP;
	 
	 @Before
	 public void setUp(){
	 
		 contP = new ControllerPessoa();
	 
	 }	
	 
	 @Test
		public void testInserirVendedorComSucesso(){
			
			Pessoa pes = new Pessoa("Jose","Jose@gmail.com","555","Rua A",88776655);
			
			
			contP.inserirVendedor(pes, 1000d);
			
			Iterador itr = contP.listarVendedor();
			Vendedor vendRetorno = null;
			
			while(itr.temProximo()){
				vendRetorno = (Vendedor) itr.obterProximo();
			}
			assertEquals("Jose",vendRetorno.getNome());
			assertEquals("Jose@gmail.com",vendRetorno.getEmail());
			assertEquals("555",vendRetorno.getCpf());
			assertEquals("Rua A",vendRetorno.getEndereco());
			assertEquals(Integer.valueOf(88776655),vendRetorno.getTelefone());
			assertEquals(1000d,vendRetorno.getSalario());
		}
		
	 @Test
		public void testInserirClienteComSucesso(){
			
			Pessoa pes = new Pessoa("Mario","Jose@gmail.com","444","Rua A",88776655);
			contP.inserirCliente(pes);
			
			Iterador itr = contP.listarClientes();
			Cliente clienteRetorno = null;
			
			while(itr.temProximo()){
				clienteRetorno = (Cliente) itr.obterProximo();
				break;
			}
			assertEquals("Mario",clienteRetorno.getNome());
			assertEquals("Jose@gmail.com",clienteRetorno.getEmail());
			assertEquals("444",clienteRetorno.getCpf());
			assertEquals("Rua A",clienteRetorno.getEndereco());
			assertEquals(Integer.valueOf(88776655),clienteRetorno.getTelefone());
		}
	 
	 @Test
	 public void testOrdenacaoVendedores(){
		 
		 Pessoa pes = new Pessoa("Jose","Jose@gmail.com","111","Rua A",88776655);
		 Pessoa pes2 = new Pessoa("Hiago","Hiago@gmail.com","222","Rua B",99776655);
		 Pessoa pes3 = new Pessoa("Carlos","Carlos@gmail.com","333","Rua C",33776655);
		 
		 contP.inserirVendedor(pes2, 1000d);
		 contP.inserirVendedor(pes, 1000d);
		 contP.inserirVendedor(pes3, 1000d);
		 Pessoa [] vetor;
		 vetor = contP.ordenarVendedor();
		 
		 assertEquals("Carlos",vetor[0].getNome());
		 assertEquals("Hiago",vetor[1].getNome());
		 assertEquals("Jose",vetor[2].getNome());
		 
	 }
	
	 @Test
	 public void testOrdenacaoClientes(){
		 
		 Pessoa pes = new Pessoa("Mario","Mario@gmail.com","123","Rua A",88776655);
		 Pessoa pes2 = new Pessoa("Hiago","Hiagoa@gmail.com","133","Rua B",99776655);
		 Pessoa pes3 = new Pessoa("Carlos","Carlos@gmail.com","232","Rua C",33776655);
		 
		 contP.inserirCliente(pes3);
		 contP.inserirCliente(pes2);
		 contP.inserirCliente(pes);
		 
		 Pessoa[] vetor;
		 vetor = contP.ordenarClientes();
		 
		 assertEquals("Carlos",vetor[0].getNome());
		 assertEquals("Hiago",vetor[1].getNome());
		 assertEquals("Mario",vetor[2].getNome());
	 }
	 
	 @Test
	 public void testExcluirClienteComSucesso(){
		 Pessoa pes = new Pessoa("Mario","Mario@gmail.com","2019","Rua A",88776655);
		 contP.inserirCliente(pes);
		 assertEquals(true,contP.excluirCliente("2019"));
		 
	 }
	 
	 @Test
	 public void testExcluirClienteSemSucesso(){
		 Pessoa pes = new Pessoa("Mario","Mario@gmail.com","123","Rua A",88776655);
		 contP.inserirCliente(pes);
		 assertEquals(false,contP.excluirCliente("a122"));
		 
	 }
	 
	 @Test
	 public void testExcluirVendedorComSucesso(){
		 
		 Pessoa pes = new Pessoa("Mario","Mario@gmail.com","2019","Rua A",88776655);
		 contP.inserirVendedor(pes,1000);
		 assertEquals(true,contP.excluirVendedor("2019"));
	 }
	 
	 @Test
	 public void testExcluirVendedorSemSucesso(){
		 
		 Pessoa pes = new Pessoa("Mario","Mario@gmail.com","907","Rua A",88776655);
		 contP.inserirVendedor(pes,1100);
		 assertEquals(false,contP.excluirCliente("34aa"));

		 
		 
	 }
	 
}