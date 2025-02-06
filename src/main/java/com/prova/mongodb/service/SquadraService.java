package com.prova.mongodb.service;

import java.util.List;

import com.prova.mongodb.model.Squadra;

public interface SquadraService {

	public List<Squadra> getAllSquadre();
	public Squadra addSquadra(Squadra squadra);
	
}
