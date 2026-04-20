package com.FiapDelivery.Sistema;

import com.FiapDelivery.Classes.Caminhao;
import com.FiapDelivery.Classes.Pacote;
import com.FiapDelivery.Classes.Rota;

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
	
	public static void main(String[] args) {
		// Iniciando variáveis para swicth case:
		Scanner scanner = new Scanner(System.in);
		boolean sair = false;
		
		// Sistema para o usuário:
		while(sair == false) {
			// Opções:
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
	    		System.out.println("Desligando sistema...");
	        	sair = true;
	        	break;
	        	
	    	case 1: // Teste de erros
	    		System.out.println("----------- TESTE DE ERROS ---------");
	        	// Erros veículo:
	    		System.out.println("Erros dos veículos ao tentar inicializar objetos com");
	        	System.out.println("String da placa vazia e com peso menor ou igual a 0:");
	        	try {
	                Caminhao erroCaminhao = new Caminhao("", -1);
	                System.out.println("Caminhão criado com sucesso!");
	            } catch (IllegalArgumentException e) {
	                System.err.println(e.getMessage());
	            }
	        	
	        	// Erros pacote:
	        	System.out.println("\nErros dos pacotes ao tentar inicializar objetos com");
	        	System.out.println("String do código vazio e com peso menor ou igual a 0:");
	        	try {
		        	Pacote erroPacote = new Pacote("", "", 0);
	                System.out.println("Pacote criado com sucesso!");
	            } catch (IllegalArgumentException e) {
	                System.err.println(e.getMessage());
	            }
	        	
	        	// Erros rota:
	        	System.out.println("\nErros das rotas ao tentar inicializar objetos com");
	        	System.out.println("String do local de retirada e de entrega vazios:");
	        	try {
	        		// Iniciando Objetos de forma correta para exibir o erro da Rota:
	        		Caminhao erroRotaCaminhao = new Caminhao("RGB1234", 4000);
	        		Pacote erroRotaPacote = new Pacote("aad8AD8ad", "20x Pneus", 500);
	        		
	        		Rota rota = new Rota(erroRotaPacote, erroRotaCaminhao, "A", "");
	                System.out.println("Rota criada com sucesso!");
	            } catch (IllegalArgumentException e) {
	                System.err.println(e.getMessage());
	            }
	        	
	        	esperarUsuario(scanner);
	        	break;
	        	
	    	case 2: // Mostrar mercadorias disponíveis
	    		System.out.println("- LISTA DE MERCADORIAS DISPONÍVEIS -");
	        	
	        	esperarUsuario(scanner);
	        	break;
	        	
	    	case 3: // Visualizador de pedidos
	    		System.out.println("----------- SEUS PEDIDOS -----------");
	        	
	        	esperarUsuario(scanner);
	        	break;
	    	default:
	    		System.out.println("SELECIONE UMA OPÇÃO VÁLIDA!!");
			}
		}
		
		// Fechando scanner:
		scanner.close();
	}
}
