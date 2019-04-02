package br.uefs.ecomp.hemoba.main.view;

import br.uefs.ecomp.hemoba.main.controller.Controller;
import br.uefs.ecomp.hemoba.main.model.Doador;
import br.uefs.ecomp.hemoba.main.model.Posto;
import br.uefs.ecomp.hemoba.main.util.Iterador;
import br.uefs.ecomp.hemoba.main.model.Doacao;
import br.uefs.ecomp.hemoba.main.util.Data;

import java.io.IOException;
import java.util.Calendar;

/*
 * Classe View , possui a funcao de exibir e pegar os dados do usuario
 * e enviar para a classe Controller.
 */

public class View {
    
	public static void main(String[] args) throws IOException{
        
 /*Doador*/ String nome, responsavelDoador, endereco,telefone, documento;
            int dia, mes,ano;double peso;int matricula = 0;
            Data dataN;
            
 /*Posto*/  int numeroPosto=0; String enderecoPosto, responsavelPosto;   
            String telefonePosto;
            
 /*Doacao*/ int diaDoacao,mesDoacao,anoDoacao, horaDoacao = 0; boolean status;
            Data dataD;int numeroDPosto = 0, numeroMatricula = 0;
        
        Iterador itrDoador;    
        Iterador itrPosto;
        Iterador itrDoacao;
        
        Controller cont = new Controller();
        Calendar data = Calendar.getInstance();
        
        int op;
        
        boolean menu = true;
        
        do{
        System.out.println("======== MENU ========");
        
        System.out.println("<1>  CADASTRAR DOADOR");
        System.out.println("<2>  CADASTRAR POSTO");
        System.out.println("<3>  CADASTRAR DOACAO");
        System.out.println("<4>  ATUALIZAR DOACAO");
        System.out.println("<5>  CONSULTAR DOADOR");
        System.out.println("<6>  CONSULTAR POSTO");
        System.out.println("<7>  EXCLUIR DOACAO");
        System.out.println("<8>  LISTAR DOADORES");
        System.out.println("<9>  LISTAR POSTOS DE DOACAO");
        System.out.println("<10> LISTAR DOACOES DO DIA");
        System.out.println("<11> LISTAR DOACOES REALIZADAS");
        System.out.println("<12> LISTAR DOACOES NAO REALIZADAS");
        System.out.println("<0>  SAIR");
        
        System.out.println("ESCOLHA : ");
        op =Console.readInt();
        
        switch(op){
            
        	case 0:
            
        		System.out.println("FECHANDO PROGRAMA");
                menu = false;
                break;
            
            case 1:
            	System.out.println("\nCADASTRAR DOADOR :\n");
            	
                System.out.println("Nome : ");
                nome = Console.readString();
                System.out.println("\nDocumento");
                documento = Console.readString();
                System.out.println("\nEndereco : ");
                endereco = Console.readString();
                System.out.println("\nTelefone : ");
                telefone = Console.readString();
                System.out.println("\nData de Nascimento");
                
                System.out.println("\nDia : ");
                dia = Console.readInt();
                
                System.out.println("\nMes : ");
                mes = Console.readInt();
                
                System.out.println("\nAno :");
                ano = Console.readInt();
                
                dataN = new Data();
                dataN.setDia(dia);
                dataN.setMes(mes);
                dataN.setAno(ano);
                 
                int idade = data.get(Calendar.YEAR) - ano;
                if(idade < 18 && idade >=16){
                    
                	System.out.println("Responsavel Doador : ");
                    responsavelDoador = Console.readString();
                    
                }else{
                
                	responsavelDoador = "Nao Precisa";
                }
                
                
                System.out.println("Peso: ");
                peso = Console.readDouble();
                if(peso < 50 || idade <16 || idade > 69 ){
                	System.out.println("\nPESSOA NAO ESTA ATENDE AOS REQUISITOS PARA FAZER A DOACAO! \n");
                }else{
                matricula ++;
                cont.cadastrarDoador(nome, endereco, telefone, dataN,peso , responsavelDoador,documento,matricula);
                System.out.println("CADASTRO REALIZADO COM SUCESSO\n");
                }
                break;
            
            case 2:
            	
            	System.out.println("\nCADASTRAR POSTO : \n");
            	
                System.out.println("\nEndereco : ");
                enderecoPosto =Console.readString();
                
                System.out.println("\nTelefone : ");
                telefonePosto = Console.readString();
                
                System.out.println("\nResponsavel : ");
                responsavelPosto =Console.readString();
                
                numeroPosto++;
                
                cont.cadastrarPosto(enderecoPosto, telefonePosto, responsavelPosto,numeroPosto);
                System.out.println("CADASTRO REALIZADO COM SUCESSO\n");
                
                break;
            
            case 3:
            	
            	itrDoador = cont.listarDoadores();
            	itrPosto = cont.listarPostos();
            	itrDoacao = cont.listarDoacoesDia();
            	
            	boolean laco = true;
            	
            	if(itrDoador == null || itrPosto == null){
            		System.out.println("\nNão existe Doacao ou um Posto Cadastrado !\n\n");
            	}else{
            		System.out.println("\nCADASTRAR DOACAO : \n");
            		
                System.out.println("\nDigite o dia : ");
                diaDoacao = Console.readInt();
                System.out.println("\nDigite o mes : ");
                mesDoacao = Console.readInt();
                System.out.println("\nDigite o ano : ");
                anoDoacao = Console.readInt();
                
                while(laco != false){
                
                System.out.println("Digite um horario entre as 7 horas e 18 horas !\n");
                horaDoacao = Console.readInt();
                if(itrDoacao == null && horaDoacao >= 7  && horaDoacao <= 18 ){
                	
                	laco = false;
                	
                }else if (itrDoacao != null){
                	
                	if(horaDoacao >= 7  && horaDoacao <= 18 ){
                		itrDoacao  = cont.listarDoacoesDia();
                	while(itrDoacao.temProximo()){
                		Doacao d = (Doacao) itrDoacao.obterProximo();
                		if(d.getHora() == horaDoacao && d.getDataD().getDia() == diaDoacao && d.getDataD().getMes() == mesDoacao){
                			System.out.println("\nESSE HORARIO JA ESTA OCUPADO ! \n");
                			laco = true;
                			
                		}else               		
                			laco = false;
                	}
                
                }
                
              } 
             
             }
                
                dataD = new Data();
                dataD.setDia(diaDoacao);
                dataD.setMes(mesDoacao);
                dataD.setAno(anoDoacao);
                                                
                laco = true;
                Posto  p;
                while (laco != false){
                	itrPosto = cont.listarPostos();
                	
                	while(itrPosto.temProximo()){
                		
                		System.out.println("Digite o numero do Posto : ");
                        numeroDPosto = Console.readInt();
                        
                        p = (Posto) itrPosto.obterProximo();
                        
                		if(p.getNumeroP() == numeroDPosto){
                		laco = false;
                		break;
                		}else{
                			System.out.println("Esse Posto ainda não está cadastrado!\n\n\n"); 
                		}
                	
                	}
                }   
                
                laco = true;
                Doador d;
                while(laco != false){
                	itrDoador = cont.listarDoadores();
                    
                    while(itrDoador.temProximo()){
                    	System.out.println("Digite a matricula do Doador : ");
                        numeroMatricula = Console.readInt();
                    	d = (Doador) itrDoador.obterProximo();
                    if(numeroMatricula == d.getMatricula()){
                    	laco = false;
                    	break;
                    }else{
                    	 System.out.println("Esse Doador ainda não está cadastrado!\n\n\n");
                    }
                    
                   }
                }
                
                itrDoacao = cont.listarDoacoesDia();
                Doacao doacao;
                boolean confirma = false;
                
                if(itrDoacao == null){
                	//Segue a execucao
                }else{
                while(itrDoacao.temProximo()){
                	doacao = (Doacao) itrDoacao.obterProximo();
                	if(doacao.getMatriculaD() == numeroMatricula){
                		confirma = true;
                		break;
                	}
                	
                }
           }    
                if(confirma == false){
                status = false;
                
                System.out.println("Status Doacao : Não Realizado");
                
                cont.cadastrarDoacao(dataD, horaDoacao,numeroDPosto ,numeroMatricula, status);
            	System.out.println("CADASTRO REALIZADO COM SUCESSO\n");
                
                }else{
                	System.out.println("JA EXISTE UMA DOACAO CADASTRADA PARA ESSE DOADOR\n\n");
                	
                }
           }
            	
            	break;
            
            case 4:
            	
            	
            	System.out.println("\nATUALIZAR DOACAO : \n");
            	itrDoacao = cont.listarDoacoesDia();
            	
            	if(itrDoacao == null){
            		System.out.println("\nNao existe Doacao Cadastrada\n");
            	}
            	else{
            		Doacao d;
            		
            		System.out.println("Digite um Dia :");
            		diaDoacao = Console.readInt();
            		
            		System.out.println("Digite um mes :");
            		mesDoacao = Console.readInt();
            		
            		System.out.println("Digite uma hora :");
            		horaDoacao = Console.readInt();
            		
            		while(itrDoacao.temProximo()){
            			d = (Doacao) itrDoacao.obterProximo();
            			if(d.getDataD().getDia() == diaDoacao && d.getDataD().getMes() == mesDoacao){
            				if(d.getHora() == horaDoacao){
            					d.setStatus(true);
            					System.out.println("Doacao Realizada\n");
            					
            				}
            			}
            			
            		}
            		
            	}
            	
            	
            	
                break;
                
            case 5:
            	
            	System.out.println("\nCONSULTAR DOADOR : \n");
            	
            	Doador d;
            	System.out.println("Digite o numero da matricula do doador");
            	int mat = Console.readInt();
            	d=cont.obterDoador(mat);
            	if(d==null){
            		System.out.println("Doador nao encontrado");
            	}else{
            		System.out.println(d.toString());
            	}
                break;
            
            case 6:
            	
            	System.out.println("\nCONSULTAR POSTO : \n");
            	
            	Posto pt;
            	System.out.println("Digite o numero do posto");
            	int numP= Console.readInt();
            	pt =cont.obterPosto(numP);
            	if(pt==null){
            		System.out.println("Posto nao encontrado");
            	}else{
            		System.out.println(pt.toString());
            	}
                
                break;
          
            case 7:
            	
            	System.out.println("\nEXCLUIR DOACAO : \n");
            	
            	System.out.println("Digite a matricula : ");
                matricula = Console.readInt();
                System.out.println("Digite o dia da doacao: ");
                diaDoacao = Console.readInt();
            
                cont.excluirDoacao(matricula,diaDoacao);
                
                break;
            	
            case 8:
            	
            	System.out.println("\nLISTA DE DOADORES : \n");
            	
                itrDoador = cont.listarDoadores();
                
                if(itrDoador==null){
                	System.out.println("Nao há Doador");
                } else{
                	while(itrDoador.temProximo()) {
                		System.out.println(((Doador)itrDoador.obterProximo()).toString());
                	}
                }
                break;
                
            case 9:
            	
            	System.out.println("\nLISTA DE POSTOS : \n");
            	
            	itrPosto = cont.listarPostos();
            	if(itrPosto==null){
            		System.out.println("Nao há Posto");
            	}else{
            		while(itrPosto.temProximo()){
            			System.out.println(((Posto)itrPosto.obterProximo()).toString());
            		}
            	}
               
            	break;
            
            case 10:
            	
            	System.out.println("\nLISTA DE DOACOES DO DIA : \n");
            	
            	itrDoacao = cont.listarDoacoesDia();            	
            	if(itrDoacao == null){
            		
            		System.out.println("Não existe Doacao Cadastrada");
            	
            	}else{
            		Doacao a = (Doacao) itrDoacao.obterProximo();
                	
                	System.out.println("Digite o dia ");
                	diaDoacao = Console.readInt();
                	
                	System.out.println("Digite o mes");
                	mesDoacao = Console.readInt();
                
            		for(int i = 7; i <= 18;i++){
            			itrDoacao = cont.listarDoacoesDia();
            		
            			while(itrDoacao.temProximo() && a.getDataD().getDia() == diaDoacao && a.getDataD().getMes() == mesDoacao){
                	
                		
            			if( a.getHora() == i){
            				
            				System.out.println(a.toString());
            			}
            			
            			a = (Doacao) itrDoacao.obterProximo();            		
            		}
            	}		
           }  	
            	
            	break;
            	
            case 11:
            	
            	System.out.println("\nLISTA DE DOACOES REALIZADAS : \n");
            	
            	itrDoacao = cont.listarDoacoesRealizadas();
                Doacao auxD;
                if(itrDoacao == null){
                	System.out.println("Não existe Doacao Cadastrada");
                }else{
                	while(itrDoacao.temProximo()){
                		auxD = (Doacao)itrDoacao.obterProximo();
                		if(auxD.isStatus()){
                			System.out.println(auxD.toString());
                		}
                	}
                }
            	
                break;
                
            case 12:
            	
            	System.out.println("\nLISTA DE DOACOES NAO REALIZADAS : \n");
            	
            	itrDoacao = cont.listarDoacoesNaoRealizadas();
                Doacao aux;
                if(itrDoacao == null){
                	System.out.println("Não existe Doacao Cadastrada");
                }else{
                	while(itrDoacao.temProximo()){
                		aux = (Doacao)itrDoacao.obterProximo();
                		if(!aux.isStatus()){
                			System.out.println(aux.toString());
                		}
                	}
                }
                
                break;
                
            default:
                System.out.println("Digite Numero entre 0 e 12");
            }          
            
        }while(menu != false);
        
        
    }
}
