package com.FiapDelivery.Sistema;

import com.FiapDelivery.Classes.Caminhao;
import com.FiapDelivery.Classes.Moto;
import com.FiapDelivery.Classes.Pacote;
import com.FiapDelivery.Classes.Pedidos;
import com.FiapDelivery.Classes.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaPrincipal {
	// Apenas um "segurador de página":
	Scanner scanner = new Scanner(System.in);
	private static void esperarUsuario(Scanner scanner) {
	    while (true) {
	        System.out.println("\n-- 0: para voltar --");
	        if (scanner.nextInt() == 0) {
	            break;
	        }
	        System.out.println("Opção inválida!");
	    }
	}
	
	// Para ajudar na clareza do terminal:
	private static void limparTela() {
	    for (int i = 0; i < 30; i++) {
	        System.out.println();
	    }
	}
	
	// Históricos para armazenar os pacotes e suas entregas:
	static List<Pacote> historicoDePacotes = new ArrayList<>();
	static List<Pedidos> historicoDePedidos = new ArrayList<>();
	
	public static void main(String[] args) {
		// Iniciando variáveis para swicth case:
		Scanner scanner = new Scanner(System.in);
		boolean sair = false;
		
		// Variáveis de rotas, já que por enquanto vou fazer elas estáticas:
		String localRetirada = "Loja";
		String localEntrega = "Sua casa";
		
		// Sistema para o usuário:
		while(!sair) {
			
			// Opções:
			limparTela();
			boolean sairMercadorias = false;
			System.out.println("------------------------------------");
			System.out.println("-- Selecione a opção que desejar: --");
			System.out.println("------------- 0: Sair --------------");
			System.out.println("--------- 1: Testar erros ----------");
			System.out.println("-------- 2: Fazer pedidos ----------");
			System.out.println("------ 3: Visualizar pedidos -------");
			System.out.println("------------------------------------");
			System.out.print("Opção: ");
			int opcao = scanner.nextInt();
			
			// Switch case para selecionar a ação desejada:
			switch (opcao) {
	    	case 0: // Sair
	    		limparTela();
	    		System.out.println("Desligando sistema...");
	        	sair = true;
	        	break;
	        	
	    	case 1: // Teste de erros
	    		limparTela();
	    		System.out.println("----------- TESTE DE ERROS ---------");
	        	// Erros veículo:
	    		System.out.println("Erros dos veículos ao tentar inicializar objetos com");
	        	System.out.println("peso menor ou igual a 0:");
	        	try {
	                Caminhao erroCaminhao = new Caminhao(-1);
	                System.out.println("Caminhão criado com sucesso!");
	            } catch (IllegalArgumentException e) {
	                System.err.println(e.getMessage());
	            }
	        	
	        	// Erros pacote:
	        	System.out.println("\nErros dos pacotes ao tentar inicializar objetos com");
	        	System.out.println("String do código vazio e com peso menor ou igual a 0:");
	        	try {
		        	Pacote erroPacote = new Pacote("", 0);
	                System.out.println("Pacote criado com sucesso!");
	            } catch (IllegalArgumentException e) {
	                System.err.println(e.getMessage());
	            }
	        	
	        	// Erros rota:
	        	System.out.println("\nErros das rotas ao tentar inicializar objetos com");
	        	System.out.println("String do local de retirada e de entrega vazios:");
	        	try {
	        		// Iniciando Objetos de forma correta para exibir o erro da Rota:
	        		Caminhao erroRotaCaminhao = new Caminhao(4000);
	        		Pacote erroRotaPacote = new Pacote("20x Pneus", 500);
	        		
	        		Pedidos rota = new Pedidos(erroRotaPacote, erroRotaCaminhao, "A", "");
	                System.out.println("Rota criada com sucesso!");
	            } catch (IllegalArgumentException e) {
	                System.err.println(e.getMessage());
	            }
	        	
	        	esperarUsuario(scanner);
	        	limparTela();
	        	break;
	        	
	    	case 2: // Mostrar mercadorias disponíveis
	    		limparTela();
	    		// Inicializando variáveis:
				Pacote pacoteSelecionado = null;
				Moto motoEntregas = null;
				Caminhao caminhaoEntregas = null;
				Pedidos rotaPedido = null;
				
	    		while(!sairMercadorias) {
	    		System.out.println("- LISTA DE MERCADORIAS DISPONÍVEIS -");
	    		System.out.println("------------------------------------");
				System.out.println("-- Selecione o que deseja comprar: -");
				System.out.println("--- 0: Comprar os pacotes e sair ---");
				System.out.println("------ 1: 12x Garfos - 1.12 KG -----");
				System.out.println("-------- 2: Sofá - 200 KG ----------");
				System.out.println("-- 3: Carro de brinquedo - 0.3 KG --");
				System.out.println("-- 4: 10x Sacos de areia - 300 KG --");
				System.out.println("------------------------------------");
				System.out.print("Opção: ");
				int opcaoCompra = scanner.nextInt();
				
					switch (opcaoCompra) {
					case 0:
			        	sairMercadorias = true;
			            break;
			            
			        case 1:
			        	try {
			        		pacoteSelecionado = new Pacote("12x Garfos", 1.12);
			            } catch (IllegalArgumentException e) {
			                System.err.println(e.getMessage());
			            }
			            break;
			            
			        case 2:
			        	try {
			        		pacoteSelecionado = new Pacote("Sofá", 200.0);
			            } catch (IllegalArgumentException e) {
			                System.err.println(e.getMessage());
			            }
			            break;
			            
			        case 3:
			        	try {
			        		pacoteSelecionado = new Pacote("Carro de brinquedo", 0.3);
			            } catch (IllegalArgumentException e) {
			                System.err.println(e.getMessage());
			            }
			            break;
			            
			        case 4:
			        	try {
			        		pacoteSelecionado = new Pacote("10x Sacos de areia", 300.0);
			            } catch (IllegalArgumentException e) {
			                System.err.println(e.getMessage());
			            }
			            break;
			            
			        default:
			            System.out.println("Opção inválida!");
			            break;
					}
					
					if (pacoteSelecionado != null && opcaoCompra != 0) {
						historicoDePacotes.add(pacoteSelecionado);
				        System.out.println("\nSucesso! " + pacoteSelecionado.getNomePacote() + " adicionado às compras.");
				        System.out.println("Você tem " + historicoDePacotes.size() + " pacote(s) no momento.");
				    }
				}
	    		
	    		
	    		if (historicoDePacotes.isEmpty()) {
	    			break;
	    	    } else {
	    	        System.out.println(historicoDePacotes.size() + " pacote(s) comprado(s)!");
	    	        
	    	        // Selecionando motoristas e rotas para cada pacote:
	    	        for (Pacote pacoteAtual : historicoDePacotes) {
	    	        	
	    	        	// Criando o veículo com base no peso do pacote:
	    	        	if(pacoteAtual.getPesoPacote() <= 40) {
	    	        		try {
				        		motoEntregas = new Moto(40);
				        		
				        		try {
					        		rotaPedido = new Pedidos(pacoteAtual, motoEntregas, localRetirada, localEntrega);
					            } catch (IllegalArgumentException e) {
					                System.err.println(e.getMessage());
					            }
				        		
				        		// Verificando e mudando variável de capacidade, e após isso adicionando ao histórico de veículos:
				        		motoEntregas.capacidadeAposPacote(pacoteAtual.getPesoPacote());
				            } catch (IllegalArgumentException e) {
				                System.err.println(e.getMessage());
				            }
	    	        	} else {
	    	        		try {
				        		caminhaoEntregas = new Caminhao(4000);
				        		
				        		try {
					        		rotaPedido = new Pedidos(pacoteAtual, caminhaoEntregas, localRetirada, localEntrega);
					            } catch (IllegalArgumentException e) {
					                System.err.println(e.getMessage());
					            }
				        		
				        		// Verificando e mudando variável de capacidade, e após isso adicionando ao histórico de veículos:
				        		caminhaoEntregas.capacidadeAposPacote(pacoteAtual.getPesoPacote());
				            } catch (IllegalArgumentException e) {
				                System.err.println(e.getMessage());
				            }
	    	        	}
	    	        	
	    	        	historicoDePedidos.add(rotaPedido);
	    	        }
	    	    }
	    		
	    		esperarUsuario(scanner);
	    		limparTela();
		        break;
	        	
	    	case 3: // Visualizador de pedidos
	    		limparTela();
	    		System.out.println("----------- SEUS PEDIDOS -----------");
	    	
	    	    if (historicoDePedidos.isEmpty()) {
	    	        System.out.println("Seu carrinho está vazio! Vá fazer algumas compras.");
	    	    } else {
	    	        System.out.println("Status dos seus " + historicoDePedidos.size() + " pedidos(s):");
	    	        System.out.println("--------------------------------");
	    	        
	    	        // Como o número de pacotes tem que ser igual ao número de entregas, não precisamos repetir código
	    	        for (int i = 0; i < historicoDePedidos.size(); i++) {
	    	        	
	    	        	Pedidos pedidoAtual = historicoDePedidos.get(i);
	    	        	pedidoAtual.statusPedido();
	    	        }
	    	    }
	    		
	        	esperarUsuario(scanner);
	        	limparTela();
	    		break;
			}
		}
		
		// Fechando scanner:
		scanner.close();
	}
}
