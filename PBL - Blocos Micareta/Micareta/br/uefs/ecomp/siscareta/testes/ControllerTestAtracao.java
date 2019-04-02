package br.uefs.ecomp.siscareta.testes;

import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.siscareta.controller.ControllerAtracao;
import br.uefs.ecomp.siscareta.model.Atracao;
import br.uefs.ecomp.siscareta.util.Iterador;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;


	public class ControllerTestAtracao extends TestCase{
		
		private ControllerAtracao contA;
		
		@Before
		public void setUp() throws Exception{
		
			contA = new ControllerAtracao();
		
		}
		
		@Test
		public void testExcluirAtracaoComSucesso(){
			
			contA.inserirAtracao("Ivete Sangalo");
			assertEquals(true,contA.excluirAtracao(1));

		}
		@Test 
		public void testExcluirAtracaoSemSucesso(){
			
			contA.inserirAtracao("Banda Eva");
			assertEquals(false,contA.excluirAtracao(1));
			
		}
		@Test
		public void testInsereAtracaoComSucesso(){
			contA.inserirAtracao("Ivete Sangalo");
			
			Iterador itr  = contA.listarAtracoes();
			Atracao atracaoRetorno = null;
			while(itr.temProximo()){
				atracaoRetorno = (Atracao) itr.obterProximo();
				break;
			}		
			assertEquals("Ivete Sangalo", atracaoRetorno.getNome());
			assertEquals(Integer.valueOf(2),atracaoRetorno.getiD());
			
			}
		
		
	}
