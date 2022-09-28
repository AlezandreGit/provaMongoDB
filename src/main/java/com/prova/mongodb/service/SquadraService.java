package com.prova.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.mongodb.model.Squadra;
import com.prova.mongodb.repository.SquadraRepository;

@Service
public class SquadraService {

	private SquadraRepository squadraRepository;
	
	@Autowired
	public SquadraService(SquadraRepository squadraRepository) {
		this.squadraRepository = squadraRepository;
	}
	
	public List<Squadra> getAllSquadre() {
		return squadraRepository.findAll();
	}
	
	public Squadra addSquadra(Squadra squadra) {
		return squadraRepository.insert(squadra);
	}
	
}
