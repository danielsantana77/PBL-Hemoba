package br.uefs.ecomp.siscareta.view;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import br.uefs.ecomp.siscareta.controller.*;
import br.uefs.ecomp.siscareta.model.*;
import br.uefs.ecomp.siscareta.util.*;

public class Main {
	public static void main(String[] args) throws  IOException{
		
		ControllerAtracao contA =new ControllerAtracao();
		ControllerEvento contE = new ControllerEvento();
		ControllerPessoa contP = new ControllerPessoa();
		ControllerApresentacao contAP = new ControllerApresentacao();
		
		Pessoa pes;
		Camarote camarote;
		Bloco bloco;
		Atracao atracao;
		
		
		Integer iD;
		int x;
		String dado;
		
		Iterador itrCliente;
		
		Console cons = new Console();
		
		boolean menu = true;
		do{
		
		System.out.println("\n1 - CADASTRAR EVENTO");
		System.out.println("\n2 - ALTERAR/REMOVER EVENTO");// Associar Bloco ou Atração
		System.out.println("\n3 - CADASTRAR ATRACAO");
		System.out.println("\n4 - ALTERAR/REMOVER ATRACAO");
		System.out.println("\n5 - CADASTRAR CLIENTE/VENDEDOR");
		System.out.println("\n6 - ALTERAR/REMOVER CLIENTE/VENDEDOR");
		System.out.println("\n7 - LISTAR CLIENTES");
		System.out.println("\n8 - LISTAR CAMAROTES");
		System.out.println("\n9 - LISTAR RESPONSAVEIS PELOS BLOCOS/CAMAROTES");
		System.out.println("\n10 - LISTAR BLOCOS");
		System.out.println("\n11 - LISTAR VENDEDORES");
		System.out.println("\n12 - LISTAR ATRACOES");
		System.out.println("\n13 - INSERIR APRESENTACAO");
		System.out.println("\n14 - EXCLUIR APRESENTACAO");
		System.out.println("\n15 - INSERIR VENDAS");
		System.out.println("\n16 - ADICIONAR CAMISAS");
		System.out.print("\nOPCAO : ");
		int op = cons.readInt();
		
		
		switch(op){
		
		case 1:
			
			System.out.println("\nCADASTRO : ");
			System.out.println("1 - CAMAROTE\n2 - BLOCO");
			System.out.print("OPCAO : ");
			int cb = Console.readInt();
			
			if(cb == 1){
				
				System.out.print("\nDigite o nome do Camarote : ");
				String nomeCamarote = Console.readString();
				System.out.println("\n|Dados do Responsavel|");
				pes = inserirDados(contP,contE.listaB(),contE.listaC());
				
				contE.inserirCamarote(nomeCamarote, pes);
				
				System.out.println("\nCADASTRO CONCLUIDO\n");
			}else if (cb == 2){
				
				System.out.print("\nDigite o nome do Bloco : ");
				String nomeBloco = Console.readString();
				System.out.println("\n|Dados do Responsavel|");
				pes = inserirDados(contP,contE.listaB(),contE.listaC());
				
				System.out.println("\n|Inserir Dias que o Bloco ira sair|");
				LocalDate[] dataB = diasEvento(contE);
				contE.inserirBloco(nomeBloco, pes,dataB);
				
				System.out.println("\nCADASTRO CONCLUIDO\n");
			}else
				System.out.println("\nDIGITE  APENAS 1 OU 2\n");
			break;
			
		case 2:
			
			System.out.println("ALTERAR/REMOVER");
			System.out.println("\n1 - ALTERAR");
			System.out.println("2 - REMOVER");
			System.out.print("\nOPCAO : ");
			x = Console.readInt();
			
			if(x == 1){
				
				listarCamarotes(contE.listarCamarotes());
				
				System.out.println("\n1 - CAMAROTE");
				System.out.println("\n2 - BLOCO");
				System.out.print("\nOPCAO : ");
				cb = Console.readInt();
				
				if(cb == 1){
					System.out.print("\nDigite o iD do Camarote : ");
					iD = Console.readInt();
					
					camarote=contE.obterCamarote(iD);
					if(camarote != null){
						alterarCamarote(camarote);
					}else{
						System.out.println("\nCamarote nao encontrado");
					}
					
					
				}else if(cb == 2){
					
					listarBlocos(contE);
					System.out.print("\nDigite o iD do Bloco : ");
					iD = Console.readInt();
					
					bloco = contE.obterBloco(iD);
					
					if(bloco != null){
						while(true){
						System.out.println("\n1 - Alterar Dados do Bloco");
						System.out.println("2 - Alterar dias que o Bloco ira sair");
						x = Console.readInt();
						
						if(x == 1){
							alterarBloco(bloco);
							break;
						}
						else if(x == 2){
							LocalDate[] dataB =diasEvento(contE);
							bloco.setDataB(dataB);
							break;
						}else
							System.out.println("\nDigite apenas 1 ou 2");
						
						
						}
						
					}else{
						System.out.println("\nBloco nao encontrado");
					}
				
				
				}
				
			}else if (x == 2){
				
					System.out.println("\n1 - CAMAROTE");
					System.out.println("\n2 - BLOCO");
					cb = Console.readInt();
					
					if(cb == 1){
						
						listarCamarotes(contE.listarCamarotes());
						
						System.out.print("\nDigite o iD do Camarote : ");
						iD = Console.readInt();
						if(contAP.verificarCamarote(contE.obterCamarote(iD))){
							System.out.println("\nCamarote Cadastrado em uma Apresentacao\nNao e possivel Excluir");
							break;
						}else if(contE.excluirCamarote(iD)){
							System.out.println("\nCAMAROTE EXCLUIDO");
						}else
							System.out.println("\nCAMAROTE NAO EXISTE");
						
						
						
					}else if (cb == 2){
						listarBlocos(contE);
						System.out.print("\nDigite o iD do Bloco : ");
						iD = Console.readInt();
						
						if(contAP.verificarBloco(contE.obterBloco(iD))){
							System.out.println("\nBloco Cadastrado em uma Apresentacao\nNao e possivel Excluir");
							break;
						}
						
						else if(contE.excluirBloco(iD)){
							System.out.println("\nBLOCO EXCLUIDO");
						}else
							System.out.println("\nBLOCO NAO EXISTE");
						
					}
					
					
					
				}else
					System.out.println("\nDigite apenas 1 ou 2");
				
			break;
			
		case 3:
			System.out.println("\nCADASTRO ATRACAO");
			System.out.print("\nDigite o nome da atracao: ");
			String nome = Console.readString();
			
			contA.inserirAtracao(nome);
			
			System.out.println("\nCADASTRO CONCLUIDO\n");
			break;
			
		case 4:
			Iterador itrA = contA.listarAtracoes();
			
			if(itrA == null){
				System.out.println("\nNao existe Atracoes Cadastradas");
				break;
			}
			
			System.out.println("\n1 - ALTERAR ATRACAO");
			System.out.println("2- REMOVER ATRACAO");
			System.out.print("\nOPCAO : ");
			x = Console.readInt();
			
			while(itrA.temProximo()){
				System.out.println(itrA.obterProximo().toString());
			}
			
			if(x == 1){
				
				System.out.print("\nDigite o id da atracao : ");
				iD = Console.readInt();
				
				atracao =contA.obterAtracao(iD);
				
				if(atracao != null){
					alterarAtracao(atracao);
					System.out.println("\nAlteracao feita com sucesso");
					
				}else
					System.out.println("\nEssa Atracao nao existe");
					
				
				
			}else if(x == 2){
				System.out.print("\nDigite o id da atracao : ");
				iD = Console.readInt();
				
				if(contAP.verificarAtracao(iD)){
				
					System.out.println("\nAtracao cadastrada em uma Apresentacao\nNao e possivel excluir");
					break;
					
				}				
				else if(contA.excluirAtracao(iD)){
					System.out.println("\nATRACAO EXCLUIDA");
				}else
					System.out.println("\nEssa atracao nao existe!");
				
			}else
				System.out.println("\nDigite Apenas 1 ou 2");
			
			break;
		case 5:
			
			System.out.println("CADASTRO PESSOA");
			
			System.out.println("1 - CLIENTE");
			System.out.println("2 - VENDEDOR");
			
			System.out.print("\nOPCAO : ");
			int cv = Console.readInt();
			
			if(cv == 1){
			
			System.out.println("CADASTRAR CLIENTE\n");
			pes = inserirDados(contP,contE.listaB(),contE.listaC());
			contP.inserirCliente(pes);
			
			System.out.println("\nCADASTRO CONCLUIDO\n");
			
			}else if(cv == 2){
				
			System.out.println("CADASTRAR VENDEDOR");	
				
			pes = inserirDados(contP,contE.listaB(),contE.listaC());
			
			System.out.print("Digite o salario :");
			double salario = Console.readDouble();
			
			contP.inserirVendedor(pes,salario);
			System.out.println("CADASTRO CONCLUIDO");	
			}else
				System.out.println("\nDIGITE  APENAS 1 OU 2\n");	
			
			break;
		
		case 6:
			
			System.out.println("\n\nALTERAR/REMOVER");
			System.out.println("\n1 - ALTERAR");
			System.out.println("2 - REMOVER");
			System.out.print("\nOPCAO : ");
			int ar = Console.readInt();
			
			if(ar == 1){
				System.out.println("\n1 - CLIENTE");
				System.out.println("2 - VENDEDOR");
				System.out.print("\nOPCAO : ");
				 x = Console.readInt();
				if( x == 1){
					
					System.out.print("\nDigite o CPF do Cliente : ");
					dado = Console.readString();
					pes = contP.obterCliente(dado);
					
					if(pes != null){
				
						alterarDados(pes);
						System.out.println("\nALTERACAO FEITA COM SUCESSO");
					}else {
					
						System.out.println("\nCPF de Cliente Invalido!");
				
					}
			
				}else if (x == 2) {
					
					System.out.print("\nDigite o CPF do Vendedor : ");
					dado = Console.readString();
					pes = contP.obterCliente(dado);
					
					if(pes != null){
						
						alterarDados(pes);
						System.out.println("\nALTERACAO FEITA COM SUCESSO");
					}else {
					
						System.out.println("\nCPF de Vendedor Invalido");
				
					}
					
				}else{
					System.out.println("\n Digite apenas 1 ou 2");
					break;
				}
			
			}else if(ar == 2){
				System.out.println("\n1 - CLIENTE");
				System.out.println("2 - VENDEDOR");
				System.out.print("\nOPCAO : ");
				
				int y = Console.readInt();
				
				if(y == 1){
					
					System.out.print("Digite o numero do CPF do Cliente");
					 dado = Console.readString();
					
					if(contP.excluirCliente(dado))
					System.out.println("\nCLIENTE EXCLUIDO");
					else
						System.out.println("\nESSE CLIENTE NAO EXISTE");
				
				}else if(y == 2){
					
					System.out.print("Digite o numero do CPF do Vendedor : ");
					 dado = Console.readString();
					
					if(contP.excluirVendedor(dado))
						System.out.println("\nVENDEDOR EXCLUIDO");
					else
						System.out.println("\n VENDEDOR NAO EXISTE");
					
				}else{
					System.out.println("Digite apenas 1 ou 2");
					break;
				}
				
			}else
				System.out.println("Digite apenas 1 ou 2");
			break;
			
		case 7:
			listarClientes(contP,contAP);
			break;
		
		case 8:
			
			listarCamarotes(contE.listarCamarotes());
			
			break ;
		
		case 9:
			listarResponsavel(contE.listarBlocos(),contE.listarCamarotes());
			break;
		
			
		case 10:
			
			if(contE.listarBlocos() == null){
				System.out.println("Nao existe Blocos Cadastrados");
			}else
			listarBlocos(contE);
			
			break;
		
		case 11:
			
			listarVendedores(contP);
			
			
			break;
		case 12:
			listarAtracoes(contA,contAP);
			break;
		case 13:
			
			System.out.println("\n1 - BLOCO/ATRACAO");
			System.out.println("2 - CAMAROTE/ATRACAO");
			System.out.print("OPCAO : ");
			x = Console.readInt(); 
			if(x==1){
				associarAtracaoBloco(contA,contE,contAP);
				
			}else if(x==2){
				
				associarAtracaoCamarote(contA,contE,contAP);
			
			}else
				System.out.println("\nDIGITE APENAS 1 OU 2 PARA FAZER A ASSOCIACAO");
			
			
			break;
		case 14:
			
			System.out.println("\nEXCLUIR APRESENTACAO");
			excluirApresentacao(contAP);
			break;
		
		case 15:
			inserirVendas(contAP,contP);
			break;
		case 16 :
			adicionarCamisas(contAP);
			break;
			
		case 17:
			menu=false;
			break;

		}
		
		
		}while(menu != false);
		
	}
	/*
	 *  Metodo com a funçao de adicionar mais Camisas a Apresentação,
	 *  e posteriormente verificar se há uma venda na Lista de Espera
	 */
	public static void adicionarCamisas(ControllerApresentacao contAP) throws IOException {
		
		Iterador itrAP = contAP.listarAP();
		
		if(itrAP == null){
			System.out.println("\nNao existe nenhuma Apresentacao Cadastrada");
		}else{
			
			while(itrAP.temProximo()){
				System.out.println(itrAP.obterProximo().toString());
			}
		
		System.out.print("\nDigite o ID da Apresentacao que quer adicionar Camisas");	
		Integer num = Console.readInt();
		Apresentacao apr = contAP.obterApresentacao(num);
		
		if(apr == null){
			System.out.println("\nEssa Apresentacao nao esta Cadastrada");
			return;
		}
		
		System.out.print("\nDigite o numero de camisas que quer adicionar : ");
		Integer camisas = Console.readInt();
		
		contAP.adicionarCamisas(apr,camisas);
		
		contAP.verificarListadeEspera(apr);
		
		}
	}
	
	/*
	 *Metodo com a funçao de inserir Dados do Objeto Pessoa
	 *passando as Listas de Bloco e Camarote, para na inserção
	 *verificar se ha um cpf existente 
	 */

	public static Pessoa inserirDados(ControllerPessoa contP, Lista listBloco, Lista listCamarote) throws IOException{
		
		Integer telefone;
		String nome,endereco,email,cpf = "0";
		boolean sair = false;
		
		System.out.print("\nDigite seu nome: ");
		nome = Console.readString();
		
		System.out.print("\nDigite seu endereco: ");
		endereco = Console.readString();
		
		while(sair != true){
		
		System.out.print("\nDigite seu CPF : ");
		cpf = Console.readString();
		
			if(contP.verificarCpf(cpf, listBloco, listCamarote)){
				sair = true;
				
			}else{
				System.out.println("\nEsse cpf ja esta cadastrado, por favor digite outro!");
			}
		
		}
		System.out.print("\nDigite seu telefone : ");
		telefone = Console.readInt();
		
		System.out.print("\nDigite seu email : ");
		email = Console.readString();
		
		return new Pessoa(nome,email,cpf,endereco,telefone);
		
		
	}
	
	/*
	 *Metodo com funcao de alterar os Dados do tipo Pessoa,
	 *com a escolha do usuario de qual Dado ele deseja alterar 
	 */

	public static void alterarDados( Pessoa pes) throws NumberFormatException, IOException{
		
		
		boolean menu = true;
		
		do{
		
		System.out.println("\n1 - NOME");
		System.out.println("2 - EMAIL");
		System.out.println("3 - ENDERECO");
		System.out.println("4 - CPF");
		System.out.println("5 - TELEFONE");
		
		System.out.print("\nOPCAO : ");
		int op = Console.readInt();
		
		
		
		switch (op){
		
		case 1:
			
			System.out.print("\nNome : ");
			String nome = Console.readString();
			pes.setNome(nome);
			
			break;
		case 2:
			
			System.out.print("\nEmail : ");
			String email = Console.readString();
			pes.setEmail(email);
		
			break;
		
		case 3 : 
			
			System.out.print("\nEndereco : ");
			String ender  = Console.readString();
			pes.setEndereco(ender);	
			
			break;
		
		case 4:
			
			System.out.print("\nCPF : ");
			String cpf  = Console.readString();
			pes.setCpf(cpf);;	
			
			break;
		case 5 :
			
			System.out.print("\nTelefone : ");
			Integer tel = Console.readInt();
			pes.setTelefone(tel);
			
			break;
		default :
			System.out.println("Numero Incorreto");
		}
		
		
		while(true){
		System.out.println("\nDeseja Continuar  ? ");
		System.out.println("\n1 - SIM\n2 - NAO");
		System.out.print("\nOPCAO : ");
		op = Console.readInt();
		
		
		if(op == 1){
			
		
		}else if(op == 2){
			menu = false;
			return;
		
		}else
			System.out.println("\nDigite apenas 1 ou 2");
	
	}
	
		}while(menu != false);
	
	}
	
	/*
	 *Altera os dados do camarote recebendo um objeto do tipo Camarote
	 * que é chamado no na funcao do Controller ObterCamarote
	 */

	
	public static void alterarCamarote(Camarote cam) throws IOException{
		
		boolean menu = true;
		do{
		System.out.println("\n1 - ALTERAR NOME DO CAMAROTE");
		System.out.println("2 - ALTERAR DADOS DO RESPONSAVEL");
		System.out.print("\nOPCAO : ");
		int x = Console.readInt();
		
		if(x == 1){
			System.out.print("\nNome : ");
			String nome = Console.readString();
			cam.setNome(nome);
		}else if(x == 2){
			alterarDados(cam.getResponsavel());
			System.out.println();
		}else
			System.out.println("\nDIGITE APENAS 1 OU 2");
		
		while(true){
			System.out.println("\nDeseja Continuar  ? ");
			System.out.println("\n1 - SIM\n2 - NAO");
			System.out.print("\nOPCAO : ");
			int op = Console.readInt();
			
			
			if(op == 1){
				
			
			}else if(op == 2){
				menu = false;
				return;
			
			}else
				System.out.println("\nDigite apenas 1 ou 2");
		
		}
		
		}while(menu!= false);
		
		
	}
	
	/*
	 * Metodo semelhante ao metodo alterarCamarote, sendo que este metodo
	 * tem a função de alterar os Dados do Objeto tipo Bloco
	 */

	public static void alterarBloco(Bloco blo) throws IOException{
		
		boolean menu = true;
		do{
		System.out.println("\n1 - ALTERAR NOME DO BLOCO");
		System.out.println("2 - ALTERAR DADOS DO RESPONSAVEL");
		System.out.print("\nOPCAO : ");
		int x = Console.readInt();
		
		if(x == 1){
			System.out.print("\nNome : ");
			String nome = Console.readString();
			blo.setNome(nome);
		}else if(x == 2){
			alterarDados(blo.getResponsavel());
			System.out.println();
		}else
			System.out.println("\nDIGITE APENAS 1 OU 2");
		
		while(true){
			System.out.println("\nDeseja Continuar  ? ");
			System.out.println("\n1 - SIM\n2 - NAO");
			System.out.print("\nOPCAO : ");
			int op = Console.readInt();
			
			
			if(op == 1){
				
			
			}else if(op == 2){
				menu = false;
				return;
			
			}else
				System.out.println("\nDigite apenas 1 ou 2");
		
		}
		
		}while(menu!= false);
		
		
	}
	
	/*
	 *Metodo com a função de alterar as Atracoes, recebendo
	 *uma atração por parametro 
	 */

	private static void alterarAtracao(Atracao atr) throws IOException{
		
		System.out.print("Digite o novo nome : ");
		String nome = Console.readString();
		atr.setNome(nome);
		
		
		
	}
	
	/*
	 * Lista os Dados dos Camarotes na Tela
	 */

	
	private static void listarCamarotes(Iterador itr){
		
		if(itr != null){
			
			while(itr.temProximo()){
				System.out.println(itr.obterProximo().toString());
				
			}
					
		}else
			System.out.println("\nNão existe Camarote Cadastrado\n");
		
		
	}
	
	/*
	 * Lista os Dados das Pessoas Responsaveis, juntamente com os Blocos ou Camarotes
	 * que ele são responsaveis
	 */

	
	private static void listarResponsavel(Iterador itrBloco, Iterador itrCam){
		
		Camarote camarote;
		Bloco bloco;
		
		if(itrBloco == null){
			System.out.println("\nNão existe Bloco cadastrado");
		}else{
			System.out.println("\nBLOCOS");
			while(itrBloco.temProximo()){
				bloco = (Bloco)itrBloco.obterProximo();
				System.out.println("\nResponsavel : "+bloco.getResponsavel().getNome());
				System.out.println("Bloco : "+ bloco.getNome());
				
			}
			
		}
		
		if(itrCam == null){
			System.out.println("Nao existe Camarote cadastrado");
		}else{
			System.out.println("\nCAMAROTES");
			while(itrCam.temProximo()){
				camarote = (Camarote) itrCam.obterProximo();
				System.out.println("\nResponsavel : "+camarote.getResponsavel().getNome());
				System.out.println("\nCamarote : " +camarote.getNome());
			}
			
		}
		
		
		
		
	}
	
	/*
	 *Metodo com a funçao de Cadastrar os dias que Evento ira sair na Avenida
	 * verificando os dias atraves de loop com a condição de parada sendo 
	 * quando os dias digitados nao forem iguais e estiverem no intervalo
	 * do Micareta
	 */
	public static LocalDate[] diasEvento(ControllerEvento contE) throws IOException{
		
		
		LocalDate[] data = null;
		boolean sair = false;
		while(sair!=true){
			
		System.out.println("\nDigite quantos dias Evento ira sair :");
		int tam = Console.readInt();
		
		if(tam<1 || tam > 4){
			
			System.out.println("\nDigite entre 1 ou 4");
			
		}else{
			
			data = new LocalDate[tam];
			
			int x = 0;
			int[] vetor = new int[tam];
			
			boolean laco = false;
			
			//Laco para pegar os dias e armazenar em um vetor
			while(laco !=true){
				
				System.out.print("\nDigite qual dia o Evento irá sair: ");
				int dia = Console.readInt();
				
				if(contE.verificarDia(dia) ){
					int i = 0;
					for(; i < tam -1;i ++){
						if(contE.verificarData(dia, vetor[i])){
							System.out.println("\nEsse dia ja esta Cadastrado");
							break;
							
						}
							
						
					}
					
					if(!contE.verificarData(dia, vetor[i])){
					vetor[x]=dia;
					x++;
					System.out.println("\nDIA CADASTRADO COM SUCESSO");
					}
			}else
			System.out.println("\nDigite apenas entre 18 e 21");
			
				if(x==tam){
					laco = true;
				}
			}// Termina variavel laço
			
			contE.ordenarData(vetor);//Ordena o vetor de dias
			
			for(int i = 0;i < tam;i ++){
				data[i] = LocalDate.of(2017, 5, vetor[i]);// Armazena no vetor de LocalDate
			}
			System.out.println("\nDias Cadastrados : "+Arrays.toString(vetor));
			return data;
			//sair = true;//Comando de saida do Laço
		
		}
	
		
	}// Termina varivel Sair
	return data;
		
}
	/*
	 *Lista os Blocos Cadastrados na Tela por dia que o Bloco
	 *sairá na Avenida 
	 */

	
	public static void listarBlocos(ControllerEvento contE){
		
		Iterador itrBloco = contE.listarBlocos();
		Bloco bloco = (Bloco) itrBloco.obterProximo();
		LocalDate[] data = bloco.getDataB();
		LocalDate aux[] = new LocalDate[1] ;
		
		for(int i = 18; i <= 21;i++){
			
			itrBloco= contE.listarBlocos();
			aux[0] = LocalDate.of(2017, 5, i);
			System.out.println("\nDIA : "+ i);
			
			while(itrBloco.temProximo()){
				
				bloco = (Bloco) itrBloco.obterProximo();
				data = bloco.getDataB();
				
				for(int j = 0; j < data.length;j++){
				
					if(contE.verificarData(data[j], aux[0])){
						System.out.println("\nBloco : "+bloco.getNome());
						System.out.println("ID : "+bloco.getiD());
					}
				}
				
			}
		}
		
	}
	
	/*
	 *Metodo com a função de inserir uma Apresentação que consiste na Associação
	 *entre uma Atracao e um Bloco 
	 */

	
	public static void associarAtracaoBloco(ControllerAtracao contA, ControllerEvento contE,
			ControllerApresentacao contAP) throws IOException{
		
		int idAtracao = 0;
		int idBloco = 0;
		if(contA.listarAtracoes() == null || contE.listarBlocos() == null){
			System.out.println("\nNAO EXISTE BLOCO OU ATRACOES CADASTRADAS");
			
		
		}else{
			listarBlocos(contE);
		while(true){
			
			System.out.print("\nDigite o ID do Bloco : ");
			idBloco = Console.readInt();
		
			if(contE.obterBloco(idBloco) == null){
				System.out.println("\nID DE BLOCO NAO CADASTRADO");
			}else
			break;
		
		}
		
		
		Iterador itrA = contA.listarAtracoes();
		
		while(itrA.temProximo()){
			System.out.println("\n");
			System.out.println(itrA.obterProximo().toString());
			
		}
		
		
		while(true){
			
			System.out.print("\nDigite o ID da Atracao : ");
			idAtracao = Console.readInt();
			
			if(contA.obterAtracao(idAtracao) == null){
				System.out.println("\nID DE ATRACAO NAO CADASTRADO");
			}else
				break;
		}
		LocalDate[] dataAP = diasEvento(contE);
		
		System.out.print("\nDigite o numero total de Camisas que serao postas a venda: ");
		Integer camisas = Console.readInt();
		
		if(contAP.inserirApresentacao(contA.obterAtracao(idAtracao), contE.obterBloco(idBloco), dataAP,camisas)){
			System.out.println("\nApresentacao Cadastrada");
		}else{
			System.out.println("\nNao foi possivel Cadastrar a Apresentacao\nEsse dia ja esta Ocupado");
		}
		
	}
		
}
	
	/*
	 *Metodo semelhante ao anterior,muda em relaçao a associação entre um Camarote
	 *e uma Atracao 
	 */

	public static void associarAtracaoCamarote(ControllerAtracao contA, ControllerEvento contE,
			ControllerApresentacao contAP) throws IOException{
		
		int idAtracao = 0;
		int idCamarote = 0;
		if(contA.listarAtracoes() == null || contE.listarBlocos() == null){
			System.out.println("\nNAO EXISTE CAMAROTE OU ATRACOES CADASTRADAS");
			
		
		}else{
			listarCamarotes(contE.listarCamarotes());
			while(true){
		
			System.out.print("\nDigite o ID do CAMAROTE : ");
			idCamarote = Console.readInt();
		
			if(contE.obterCamarote(idCamarote) == null){
				System.out.println("\nID DE CAMAROTE NAO CADASTRADO");
				}else
					break;
		
			}
			
			Iterador itrA = contA.listarAtracoes();
			
			while(itrA.temProximo()){
				System.out.println(itrA.obterProximo().toString());
			}
			
			while(true){
			
			System.out.print("\nDigite o ID da Atracao : ");
			idAtracao = Console.readInt();
			
			if(contA.obterAtracao(idAtracao) == null){
				System.out.println("\nID DE ATRACAO NAO CADASTRADO");
				}else
					break;
				}
			
			System.out.print("\nDigite o numero total de Camisas que serao postas a venda: ");
			Integer camisas = Console.readInt();
			
			
			if(contAP.inserirApresentacao(contA.obterAtracao(idAtracao), contE.obterCamarote(idCamarote),camisas)){
				System.out.println("\nApresentacao Cadastrada");
			
			}else{
				System.out.println("\nNao foi possivel Cadastrar a Apresentacao\nEsse dia ja esta Ocupado");
			}
		
		
	}

}

	/*
	 *Lista os Vendedores na Tela Ordenados pelo nome do Vendedor 
	 */

	public static void listarVendedores(ControllerPessoa contP){
		
		if(contP.listarVendedor() == null){
			System.out.println("\nNao existe vendedores cadastrados no Sistema");
		
		}else{
			
			Pessoa[] vetor;
			vetor = contP.ordenarVendedor();
			System.out.println("\nLISTA DE VENDEDORES");
			
			for(int i = 0 ; i < vetor.length; i++){
				System.out.println(vetor[i].toString());
				System.out.print("\n");
			}
			
			
		}
		
		
	}
	
	/*
	 *Lista os Clientes na tela ordenados pelo nome, juntamente com o Evento 
	 *em que esta participando e as Camisas Compradas desse evento 
	 */

	public static void listarClientes(ControllerPessoa contP,ControllerApresentacao contAP){
		
		if(contP.listarClientes() == null){
			System.out.println("\nNao existe clientes cadastrados no Sistema");
		}else{
			
			Pessoa[] vetor = contP.ordenarClientes();
			System.out.println("\nLISTA DE CLIENTES");
			int i = 0;
			Vendas aux;
			while(i<vetor.length){
				
			Iterador itrV = contAP.listarVendas();
			System.out.println(vetor[i].toString());
			
			if(itrV!=null){
			while(itrV.temProximo()){
				
				aux =(Vendas)itrV.obterProximo();
				
				if((vetor[i].getCpf()).equals(aux.getCliente().getCpf())){
					System.out.println("\nEvento : "+aux.getApr().getEvento().getNome());
					System.out.print("Camisas Compradas : "+aux.getCamisasV());
				}
				
			}
			System.out.print("\n");
			}
			i++;
		}
		
	}
}
	
	/*
	 *Metodo com a função de excluir uma Apresentacao pelo Id da mesma 
	 */

	public static void excluirApresentacao(ControllerApresentacao contAP) throws IOException{
		
		if(contAP.listarAP() == null){
			System.out.println("\nNao existe Apresentacoes Cadastradas!");
		}else{
			Iterador itrAP = contAP.listarAP();
			
			while(itrAP.temProximo()){
				System.out.println(itrAP.obterProximo().toString());
				
			}
			
			System.out.print("\nDigite o id da Apresentacao : ");
			Integer num = Console.readInt();
			if(contAP.verificarApresentacaoEmVenda(contAP.obterApresentacao(num))){
				System.out.println("\nApresentacao nao pode ser excluida\nJa ocorreu vendas dela");
				return;
			}else if(contAP.obterApresentacao(num)!= null){
				contAP.excluirApresentacao(num);
				System.out.println("\nApresentacao excluida com Sucesso!");
			}else{
				System.out.println("\nEssa Apresentacao nao existe!");
			}
			
		}
	}
	
	/*
	 * Metodo com a funçao de Cadastrar uma venda, que so é efetuada quando existe pelo menos 
	 * uma Apresentacao,um Vendedor , um Cliente e uma Atração Cadastrada no sistema
	 * Nesse metodo insere as camisas pretendidas para sair no evento, tendo um limite por dia 
	 * e qual dia do Evento se tiver cadastrado na Apresentação ele ira sair
	 */

	public static void inserirVendas(ControllerApresentacao contAP, ControllerPessoa contP) throws IOException {
		
		
		Iterador itrC = contP.listarClientes();
		Iterador itrV = contP.listarVendedor();
		
		if(itrC == null || itrV == null){
			System.out.println("\nNão Existe Clientes ou Vendedores Cadastrados no Sistema");
			return;
		}
		
		Iterador itrAP = contAP.listarAP();
		
		if(itrAP == null){
			System.out.println("\nNao existe Apresentacoes Cadastradas no Sistema");
			return;
		}
		
		System.out.print("\nDigite o cpf do cliente : ");
		String cpfCliente = Console.readString();
		Cliente c = contP.obterCliente(cpfCliente);
		
		if(c == null){
			System.out.println("\nEste cpf do Cliente nao esta Cadastrado");
			return;
		}
		
		System.out.print("\nDigite o cpf do Vendedor : ");
		String cpfVendedor = Console.readString();
		Vendedor v = contP.obterVendedor(cpfVendedor);
		
		if(v == null){
			System.out.println("\nEste cpf do Vendedor nao esta Cadastrado");
			return;
		}
		
		while(itrAP.temProximo()){
			System.out.println(itrAP.obterProximo().toString());
			
		}
		
		System.out.print("\nDigite o id da Apresentacao escolhida: ");
		Integer id = Console.readInt();
		Apresentacao apr = contAP.obterApresentacao(id);
		
		if(apr == null){
			System.out.println("\nEssa Apresentacao nao esta Cadastrada");
			return;
		}
		
		Integer numCamisas = 0; 
		
		while(true){
		
			System.out.println("\nDigite o numero de Camisas pretendidas : ");
			numCamisas = Console.readInt();
			
			if(contAP.verificarNumCamisas(numCamisas)){
				break;
			}else
				System.out.println("\nSo e possivel comprar no maximo 4 camisas por Apresentacao/dia");
			
		}
		
		Integer diaV = 0;
		LocalDate dia = null;
		boolean sair = false;
		
		while(sair != true){
		
			System.out.print("\nDigite o dia que ira sair na Apresentacao : ");
			diaV= Console.readInt();
			if(contAP.verificarDia(diaV)){
				dia = LocalDate.of(2017, 5, diaV); 
				sair = true;
			}else
				System.out.println("\nDigite apenas dias entre 18 e 22");
			
		}
		
		if(!contAP.verificarDiaCadastrado(dia, apr)){
			System.out.println("\nEsse dia nao esta Cadastrado na Apresentacao");
			return;
		}
		
			
			if(contAP.compararQtCamisas(numCamisas, apr)){//verifica se as camisas restantes é menor que a pedida pelo usuario
				
				System.out.println("\nExistem "+contAP.camisasRestantes(apr)+"Restantes");
				System.out.println("\nDeseja entrar na fila na fila de espera ? ");
				System.out.println("1 - SIM\t2 - NAO");
				int x = Console.readInt();
				
				if(x == 1){
					inserirNaFilaDeEspera(c,v,apr,numCamisas,dia,contAP);
				
				}else if(x==2){
					return;
				
				}else{
					System.out.println("\nDigite apenas 1 ou 2 ");
					return;
				}
					
			
			}else{
				
				if(contAP.inserirVendas(c, v, apr, numCamisas, dia))
				System.out.println("\nVenda Efetuada");
				else{
					System.out.println("\nVenda nao Efetuada devido ao dia ja esta cadastrado!");
				}
			}
			
			
		
		
		
	}
	
	/*
	 *Método com a funçao de inserir Vendas na fila, caso nao haja camisas suficientes na Apresentação  
	 */

	
	public static void inserirNaFilaDeEspera(Cliente cliente, Vendedor vendedor, Apresentacao apr,Integer camisasV,LocalDate dia, ControllerApresentacao contAP){
		
		contAP.inserirFila(cliente,vendedor,apr,camisasV,dia);
		
	}
	
	/*
	 *Lista as atrações separados por dia do Eventom com a quantidade de Camisas Vendidas e 
	 *Camisas colocadas a Venda 
	 */

	public static void listarAtracoes(ControllerAtracao contA, ControllerApresentacao contAP) {
		
		Iterador itrA = contA.listarAtracoes();
		Iterador itrAP = contAP.listarAP();
		
		if(itrA == null){
			System.out.println("\nNao existe Atracoes Cadastradas");
			return;
		}
		
		if(itrAP == null){
			System.out.println("\nNao existe Apresentacoes Cadastradas");
			return;
		}
		
		Atracao atr;
		Apresentacao apr;
		System.out.println("\nATRACOES");
		while(itrAP.temProximo()){
			itrA = contA.listarAtracoes();
			apr = (Apresentacao) itrAP.obterProximo();
			
			while(itrA.temProximo()){
				atr = (Atracao) itrA.obterProximo();
				System.out.println(atr.toString());
				
				if(atr.equals(apr.getAtracao())){
					System.out.println("Evento : "+apr.getEvento().getNome());
					System.out.println("Dia do Evento : "+ apr.getDataA());
					System.out.println("Camisas Colocadas a Venda : "+apr.getQtCamisas());
					System.out.println("Camisas Vendidas : "+ apr.getQtCamisasVendidas());
				}
				
			}
			
			
		}
		
		
		
	}

	
	
}
