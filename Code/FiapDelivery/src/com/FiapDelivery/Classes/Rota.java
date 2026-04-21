package com.FiapDelivery.Classes;

public class Rota {
	
	// Atributos:
	private String localRetirada;
	private String localEntrega;
	private Pacote produto;
	private Veiculo transportador;
	
	public Rota(Pacote produto, Veiculo transportador, String localRetirada, String localEntrega) {
		if(produto.getPeso() > transportador.getCapacidade()) {
			throw new IllegalArgumentException("Erro: O pacote é mais pesado que a capacidade do transportador!");
		}
		
		this.produto = produto;
		this.transportador = transportador;
		this.setLocalRetirada(localRetirada);
		this.setLocalEntrega(localEntrega);
	}
	
	// Setters:
	private void setLocalRetirada(String novoLocal) {
		// O local não pode ser nulo nem vazio:
		if (novoLocal == null || novoLocal.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro: O local de retirada informado é inválido!");
		} this.localRetirada = novoLocal;
	}
	
	private void setLocalEntrega(String novoLocal) {
		if (novoLocal == null || novoLocal.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro: O local de entrega informado é inválido!");
		} this.localEntrega = novoLocal;
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
	
}
