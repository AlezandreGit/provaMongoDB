package com.prova.mongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document("paziente")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Paziente {
	
	@Id
	private String id;
	
	@Field(name = "nome")
	private String nome;
	
	@Field(name = "cognome")
	private String cognome;
	
	@Indexed(unique=true)
	@Field(name = "codice_fiscale")
	private String codiceFiscale;
	
	private List<Sintomo> sintomi;

	public Paziente() {
		super();
	}

	@Override
	public String toString() {
		return "Paziente [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", sintomi="
				+ sintomi + "]";
	}

	
}
