package com.FiapDelivery.Classes;

public class Veiculo {
	// Atributos:
	private String placa;
	private double capacidade;
	
	protected Veiculo(String placa, double capacidade) {
		this.setPlaca(placa);
		this.setCapacidade(capacidade);
	}
	
	// Getters:
	public String getPlaca() {
		return this.placa;
	}
	
	public double getCapacidade() {
		return this.capacidade;
	}
	
	// Setters:
	private void setCapacidade(double novaCapacidade) {
		if(novaCapacidade <= 0) {
			throw new IllegalArgumentException("Erro: A capacidade não pode ser menor nem igual a 0!");
		} this.capacidade = novaCapacidade;
	}
	
	private void setPlaca(String novaPlaca) {
		// A placa não pode ser nula nem vazia:
		if (novaPlaca == null || novaPlaca.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro: A placa informada é inválida!");
		} this.placa = novaPlaca;
	}
	
}
