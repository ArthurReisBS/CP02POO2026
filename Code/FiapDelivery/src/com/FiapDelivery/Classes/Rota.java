package com.FiapDelivery.Classes;

public class Rota {
	
	// Atributos:
	private String localRetirada;
	private String localEntrega;
	private Pacote produto;
	private Veiculo transportador;
	
	public Rota(Pacote produto, Veiculo transportador, String localRetirada, String localEntrega) {
		this.produto = produto;
		this.transportador = transportador;
		this.setLocalRetirada(localRetirada);
		this.setLocalEntrega(localEntrega);
		
		if(produto.getPeso() > transportador.getCapacidade()) {
			throw new IllegalArgumentException("Erro: O pacote é mais pesado que a capacidade do transportador!");
		}
	}
	
	// Setters:
	private void setLocalRetirada(String novoLocal) {
		// O local não pode ser nulo nem vazio:
		if (novoLocal != null && !novoLocal.trim().isEmpty()) {
			this.localRetirada = novoLocal;
			System.out.println("Sucesso: O local de retirada é "+ this.localRetirada);
		} else {
			throw new IllegalArgumentException("Erro: O local de retirada informado é inválido!");
		}
	}
	
	private void setLocalEntrega(String novoLocal) {
		if (novoLocal != null && !novoLocal.trim().isEmpty()) {
			this.localEntrega = novoLocal;
			System.out.println("Sucesso: O local de entrega é "+ this.localEntrega);
		} else {
			throw new IllegalArgumentException("Erro: O local de entrega informado é inválido!");
		}
	}
	
	// Getters:
	public String getLocalEntrega() {
		return this.localEntrega;
	}
	
	public String getLocalRetirada() {
		return this.localRetirada;
	}
	
	public Pacote getPacote() {
		return this.produto;
	}
	
	public Veiculo getVeiculo() {
		return this.transportador;
	}
	
	// Métodos:
	public void statusEntrega() {
		System.out.println("------------------------------------");
		System.out.println("--- MOSTRANDO STATUS DAS COMPRAS ---");
		System.out.println("Código do pacote: "+ produto.getCodigoPacote());
		System.out.println("");
	}
}
