package br.uefs.ecomp.siscareta.testes;

import junit.framework.TestCase;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import br.uefs.ecomp.siscareta.controller.ControllerApresentacao;
import br.uefs.ecomp.siscareta.model.Apresentacao;
import br.uefs.ecomp.siscareta.model.Atracao;
import br.uefs.ecomp.siscareta.model.Bloco;
import br.uefs.ecomp.siscareta.model.Camarote;
import br.uefs.ecomp.siscareta.model.Cliente;
import br.uefs.ecomp.siscareta.model.Evento;
import br.uefs.ecomp.siscareta.model.Vendas;
import br.uefs.ecomp.siscareta.util.Iterador;


public class ControllerTestApresentacao extends TestCase {
	
	private ControllerApresentacao contAP;
	
	@Before
	public void setUp() throws Exception{
		
		contAP = new ControllerApresentacao();
	}
	
	@Test
	public void testInserirApresentacaoNoCamarote(){
		
		Atracao atr = new Atracao("Ivete Sangalo");
		Camarote cam = new Camarote ("Di Camarote",null);
		
		contAP.inserirApresentacao(atr, cam, 5);
		
		Iterador itrAP = contAP.listarAP();
		Apresentacao aprRetorno = null;
		
		while(itrAP.temProximo()){
			
			aprRetorno = (Apresentacao) itrAP.obterProximo();
			
			
		}
		
		assertEquals("Ivete Sangalo",aprRetorno.getAtracao().getNome());
		assertEquals("Di Camarote", aprRetorno.getEvento().getNome());
		
		
	}
	
	@Test
	public void testInserirApresentacaoNoBloco(){
		
		Atracao atr = new Atracao("Chiclete com Banana");
		LocalDate[] dataA = new LocalDate[1];
		dataA[0] = LocalDate.of(2017, 5, 18);
		
		Bloco blo = new Bloco("Bafo de Baco",null,dataA);
		
		contAP.inserirApresentacao(atr, blo, null, 5);
		
		Iterador itrAP = contAP.listarAP();
		Apresentacao aprRetorno = null;
		
		while(itrAP.temProximo()){
			
			aprRetorno = (Apresentacao) itrAP.obterProximo();
			
			
		}
		
		assertEquals("Chiclete com Banana",aprRetorno.getAtracao().getNome());
		assertEquals("Bafo de Baco", aprRetorno.getEvento().getNome());
		
	}
	@Test
	public void testExcluirApresentacaoNoBloco(){
		
		Atracao atr = new Atracao("Cheiro de Amor");
	
		
		Bloco blo = new Bloco("Bafo de Baco",null,null);
		
		contAP.inserirApresentacao(atr, blo, null, 5);
		
		Iterador itrAP = contAP.listarAP();
		Apresentacao aprRetorno = null;
		
		while(itrAP.temProximo()){
			
			aprRetorno = (Apresentacao) itrAP.obterProximo();
			
		}
		assertEquals(true,contAP.excluirApresentacao(aprRetorno.getId()));
		
		
		
	}
	
	@Test
	public void testExcluirApresentacaoNoCamarote(){
		
		Atracao atr = new Atracao("Cheiro de Amor");
		
		Camarote cam = new Camarote ("Di Camarote",null);
		
		contAP.inserirApresentacao(atr, cam, 5);
		
		Iterador itrAP = contAP.listarAP();
		Apresentacao aprRetorno = null;
		
		while(itrAP.temProximo()){
			
			aprRetorno = (Apresentacao) itrAP.obterProximo();
			
		}
		assertEquals(true,contAP.excluirApresentacao(aprRetorno.getId()));
		
		
		
	}
	
	@Test
	public void testInserirVendascomSucesso(){
		
		Atracao atr = new Atracao("Cheiro de Amor");
		
		Camarote cam = new Camarote ("Di Camarote",null);
		
		contAP.inserirApresentacao(atr, cam, 5);
		
		Iterador itrAP = contAP.listarAP();
		Apresentacao aprRetorno = null;
		
		while(itrAP.temProximo()){
			
			aprRetorno = (Apresentacao) itrAP.obterProximo();
			
		}
		
		
		contAP.inserirVendas(null, null, aprRetorno, 5, null);
		Iterador itrV = contAP.listarVendas();
		Vendas vendRet = null;
		
		while(itrV.temProximo()){
			
			vendRet = (Vendas) itrV.obterProximo();
		}
		
		assertEquals(Integer.valueOf(5),vendRet.getCamisasV());
		assertEquals("Cheiro de Amor",vendRet.getApr().getAtracao().getNome());
		
	}
	
	@Test 
	public void testAdicionarCamisas(){
		
		Atracao atr = new Atracao("Banda Eva");
		Camarote cam = new Camarote ("Centra Mix",null);
		
		contAP.inserirApresentacao(atr, cam, 5);
		
		Iterador itrAP = contAP.listarAP();
		Apresentacao aprRetorno = null;
		
		while(itrAP.temProximo()){
			
			aprRetorno = (Apresentacao) itrAP.obterProximo();
		}
		
		contAP.adicionarCamisas(aprRetorno, 10);
		
		assertEquals(Integer.valueOf(15),aprRetorno.getQtCamisas());
		
	}
	
	@Test
	public void testVerificarNumeroDeCamisasPedidas(){
		
		assertEquals(true,contAP.verificarNumCamisas(4));
		assertEquals(false,contAP.verificarNumCamisas(5));
		
	}
	
	@Test
	public void testVerificarDia(){
		
		assertEquals(true,contAP.verificarDia(20));
		assertEquals(false,contAP.verificarDia(25));
	}
}
