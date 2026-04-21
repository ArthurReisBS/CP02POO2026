package com.FiapDelivery.Classes;

import java.util.UUID;

public class Pacote {
	
	// Atributos:
	private String codigoPacote;
	private String nomePacote;
	private double peso;
	
	// Variáveis para decidir e mostrar a situação do pacote:
	private int situacaoPacote;
	private String situacaoPacoteFrase;
	
	public Pacote(String nomePacote, double peso) {
		this.situacaoPacote = 0;
		this.codigoPacote = UUID.randomUUID().toString().substring(0, 5).toUpperCase();
		this.setNomePacote(nomePacote);
		this.setPeso(peso);
	}
	
	// Getters:
	public String getCodigoPacote() {
		return this.codigoPacote;
	}
	
	public double getPesoPacote() {
		return this.peso;
	}
	
	public String getNomePacote() {
		return this.nomePacote;
	}
	
	public String getSituacaoPacote() {
		if(this.situacaoPacote == 0 ) {
			this.situacaoPacoteFrase = "O pedido está em fase de preparo.";
		} else if(this.situacaoPacote == 1) {
			this.situacaoPacoteFrase ="O pedido está a caminho.";
		} else {
			this.situacaoPacoteFrase = "O pedido foi entregue.";
		} return this.situacaoPacoteFrase;
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
	// Esse método ainda não foi usado no código, mas representa como seria se o pacote chegasse realmente a algum lugar:
	public void mudaSituacaoEntrega(int novaSituacao) {
		if(novaSituacao > 2 || novaSituacao < 0) {
			throw new IllegalArgumentException("Erro: A situação só pode ser marcada por 0(Preparando), 1(A caminho) e 2(Entregue)!");
		} this.situacaoPacote = novaSituacao;
	}
	
}
