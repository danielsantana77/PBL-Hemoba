package br.uefs.ecomp.siscareta.testes;

import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.siscareta.controller.ControllerEvento;
import br.uefs.ecomp.siscareta.model.*;
import br.uefs.ecomp.siscareta.util.Iterador;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;



public class ControllerTestEvento extends TestCase {

	private ControllerEvento contE;
	
	@Before
	
	public void setUp() throws Exception{
		contE = new ControllerEvento();
	}
	
	
	@Test
	public void testExcluirCamaroteComSucesso(){
		contE.inserirCamarote("Caribe", null);
		assertEquals(true,contE.excluirCamarote(1));
	}
	
	@Test
	public void testExcluirBlocoComSucesso(){
		
		contE.inserirBloco("Bafo de Baco", null,null);
		assertEquals(true,contE.excluirBloco(1));
		
	}
	
	@Test
	public void testInsereCamaroteComSucesso(){
		
		contE.inserirCamarote("Caribe", null);
		
		Iterador itr = contE.listarCamarotes();
		Camarote camRetorno = null;
		while(itr.temProximo()){
			camRetorno = (Camarote) itr.obterProximo();
			
			
		}
			assertEquals("Caribe",camRetorno.getNome());
			assertEquals(Integer.valueOf(2), camRetorno.getiD());		
	}
	
	@Test
	public void testInsereBlocoComSucesso() throws Exception{
		contE.inserirBloco("Bafo de Baco", null,null);
		
		Iterador itr  = contE.listarBlocos();
		Bloco blocoRetorno = null;
		while(itr.temProximo()){
			blocoRetorno = (Bloco) itr.obterProximo();
			
		}	
		
		assertEquals("Bafo de Baco", blocoRetorno.getNome());
		
		assertEquals(Integer.valueOf(2),blocoRetorno.getiD());
		
	}
	
	@Test
	public void testOrdenarData(){
		
		int[] vetor = {6,2,5,0};
		contE.ordenarData(vetor);
		
		assertEquals(vetor[0],0);
		assertEquals(vetor[1],2);
		assertEquals(vetor[2],5);
		assertEquals(vetor[3],6);
		
	}
	
}