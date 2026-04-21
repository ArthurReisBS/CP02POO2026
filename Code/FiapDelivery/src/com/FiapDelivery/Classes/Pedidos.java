package com.FiapDelivery.Classes;

public class Pedidos {
	
	// Atributos:
	private String localRetirada;
	private String localEntrega;
	private Pacote produto;
	private Veiculo transportador;
	
	public Pedidos(Pacote produto, Veiculo transportador, String localRetirada, String localEntrega) {
		if(produto.getPesoPacote() > transportador.getCapacidade()) {
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
	
	public String getQualVeiculo() {
		if (transportador instanceof Caminhao) {
			return "Caminhão";
		} else {
			return "Moto";
		}
	}
	
	// Método para saber das entregas:
	public void statusPedido() {
		System.out.println("--------------------------------");
		System.out.println("-------- Sobre o pacote --------");
	    System.out.println("   Código: " + produto.getCodigoPacote());
	    System.out.println("   Item: " + produto.getNomePacote());
	    System.out.println("   Peso: " + produto.getPesoPacote() + " KG");
	    System.out.println("-------- Sobre a etrega --------");
	    System.out.println("   veículo: " + getQualVeiculo());
	    System.out.println("   Placa do veículo: " + transportador.getPlaca());
	    System.out.println("   Local de retirada: " + getLocalRetirada());
	    System.out.println("   Local de entrega: " + getLocalEntrega());
	    System.out.println("   Capacidade restante do veículo: " + transportador.getCapacidade() + " KG");
	    System.out.println("--------------------------------");
	}
}
