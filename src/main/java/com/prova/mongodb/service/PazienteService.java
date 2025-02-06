package com.prova.mongodb.service;

import java.util.List;

import com.prova.mongodb.model.Paziente;

public interface PazienteService {

	public List<Paziente> getAllPazienti();
	public Paziente getPaziente(String codiceFiscale);
	
}
