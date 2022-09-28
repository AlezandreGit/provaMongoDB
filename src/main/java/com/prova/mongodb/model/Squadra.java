package com.prova.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("squadra")
public class Squadra {
	
	@Id
	private String id;
	
	@Field(name = "nome")
	private String nome;

	public Squadra() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Squadra [id=" + id + ", nome=" + nome + "]";
	}
	
}
