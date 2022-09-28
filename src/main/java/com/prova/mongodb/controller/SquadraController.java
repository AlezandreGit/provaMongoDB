package com.prova.mongodb.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.mongodb.model.Squadra;
import com.prova.mongodb.service.SquadraService;

@RestController
@RequestMapping("/api/squadra")
public class SquadraController {
	
	private static final Logger LOGGER = LogManager.getLogger(SquadraController.class);
	private SquadraService squadraService;
	
	@Autowired
	public SquadraController(SquadraService squadraService) {
		this.squadraService = squadraService;
	}
	
	@GetMapping
	public ResponseEntity<List<Squadra>> getAllSquadre() {
		LOGGER.debug("Chiamata alla getAllSquadre");
		return ResponseEntity.ok(this.squadraService.getAllSquadre());
	}
	
	@PostMapping
	public ResponseEntity<Object> addSquadra(@RequestBody(required = false) Squadra squadra) {
		LOGGER.debug("Chiamata alla addSquadra: " + squadra);
		if (squadra == null || squadra.getNome() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty Request");	
		}
		else {
			this.squadraService.addSquadra(squadra);
			return ResponseEntity.status(HttpStatus.CREATED).build();			
		}
	}

}
