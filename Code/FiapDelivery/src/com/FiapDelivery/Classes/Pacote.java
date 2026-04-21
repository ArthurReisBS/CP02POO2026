package com.FiapDelivery.Classes;

import java.util.UUID;

public class Pacote {
	
	// Atributos:
	private String codigoPacote;
	private String nomePacote;
	private double peso;
	private int situacaoEntrega;
	
	public Pacote(String nomePacote, double peso) {
		this.situacaoEntrega = 0;
		this.codigoPacote = UUID.randomUUID().toString().substring(0, 5).toUpperCase();
		this.setNomePacote(nomePacote);
		this.setPeso(peso);
	}
	
	// Getters:
	public String getCodigoPacote() {
		return this.codigoPacote;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public String getNomePacote() {
		return this.nomePacote;
	}
	
	public void getSituacaoEntrega() {
		if(this.situacaoEntrega == 0 ) {
			System.out.println("O pedido está em fase de preparo.");
		} else if(this.situacaoEntrega == 1) {
			System.out.println("O pedido está a caminho.");
		} else {
			System.out.println("O pedido foi entregue.");
		}
	}
	
	// Setters:
	private void setPeso(double novoPeso) {
		if(novoPeso <= 0) {
			throw new IllegalArgumentException("Erro: o peso não pode ser menor ou igual 0!");
		} this.peso = novoPeso;
	}
	
	private void setNomePacote(String novoNomePacote) {
		// O código não pode ser nulo nem vazio:
		if (novoNomePacote == null || novoNomePacote.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro: O nome de pacote informado é inválido!");
		} this.nomePacote = novoNomePacote;
	}
	
	// Método:
	public void mudaSituacaoEntrega(int novaSituacao) {
		if(novaSituacao > 2 || novaSituacao < 0) {
			throw new IllegalArgumentException("Erro: A situação só pode ser marcada por 0(Preparando), 1(A caminho) e 2(Entregue)!");
		} this.situacaoEntrega = novaSituacao;
	}
	
	// Métodos:
		public void pacoteStatus() {
			System.out.println("------------------------------------");
			System.out.println("--- MOSTRANDO STATUS DAS COMPRAS ---");
			System.out.println("Código do pacote: ");
			System.out.println("");
		}
}
