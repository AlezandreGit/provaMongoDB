package com.prova.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document("sintomo")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Sintomo {
	
	@Field(name = "nome")
	private String nomeSintomo;

	public Sintomo() {
		super();
	}

	@Override
	public String toString() {
		return "Sintomo [nomeSintomo=" + nomeSintomo + "]";
	}

	
}
