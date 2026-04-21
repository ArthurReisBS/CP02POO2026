package com.FiapDelivery.Classes;

import java.util.UUID;

public class Veiculo {
	// Atributos:
	private String placa;
	private double capacidade;
	
	protected Veiculo(double capacidade) {
		this.placa = UUID.randomUUID().toString().substring(0, 5).toUpperCase();
		this.setCapacidade(capacidade);
	}
	
	// Getters:
	public String getPlaca() {
		return this.placa;
	}
	
	public double getCapacidade() {
		return this.capacidade;
	}
	
	// Setter:
	private void setCapacidade(double novaCapacidade) {
		if(novaCapacidade <= 0) {
			throw new IllegalArgumentException("Erro: A capacidade não pode ser menor nem igual a 0!");
		} this.capacidade = novaCapacidade;
	}
}
