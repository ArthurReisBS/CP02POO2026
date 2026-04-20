package com.FiapDelivery.Classes;

public class Veiculo {
	// Atributos:
	private String placa;
	private double capacidade;
	
	protected Veiculo(String placa, double capacidade) {
		this.setCapacidade(capacidade);
		this.setPlaca(placa);
	}
	
	// Getters:
	public String getPlaca() {
		return this.placa;
	}
	
	public double getCapacidade() {
		return this.capacidade;
	}
	
	// Setters:
	private double setCapacidade(double novaCapacidade) {
		if(novaCapacidade <= 0) {
			System.out.println("Erro: A capacidade não pode ser menor nem igual a 0!");
			return 0;
		} return this.capacidade = novaCapacidade;
	}
	
	private void setPlaca(String novaPlaca) {
		// A placa não pode ser nula nem vazia:
		if (novaPlaca != null && !novaPlaca.trim().isEmpty()) {
			this.placa = novaPlaca;
			System.out.println("Sucesso: A placa agora é "+ this.placa);
		} else {
			System.out.println("Erro: A placa informada é inválida!");
		}
	}
	
}
