package com.prova.mongodb.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.mongodb.exception.ApplicationException;
import com.prova.mongodb.model.Paziente;
import com.prova.mongodb.service.PazienteServiceImpl;
import com.prova.mongodb.utils.Utils;

@RestController
@RequestMapping("/api/paziente")
public class PazienteController {
	
	private static final Logger LOGGER = LogManager.getLogger(PazienteController.class);
	private PazienteServiceImpl pazienteService;
	
	@Autowired
	public PazienteController(PazienteServiceImpl PazienteService) {
		this.pazienteService = PazienteService;
	}
	
	@GetMapping
	public ResponseEntity<List<Paziente>> getAllPazienti() {
		LOGGER.debug("Chiamata alla getAllPazienti");
		return ResponseEntity.ok(this.pazienteService.getAllPazienti());
	}
	
	@GetMapping("/{codiceFiscale}")
	public ResponseEntity<Paziente> getPazienteByCF(@PathVariable String codiceFiscale) {
		LOGGER.debug("Chiamata alla getPazienteByCF");
		return ResponseEntity.ok(this.pazienteService.getPaziente(codiceFiscale));
	}
	
	@PostMapping
	public ResponseEntity<Object> addPaziente(@RequestBody(required = false) Paziente paziente) throws ApplicationException {
		LOGGER.debug("Chiamata alla addPaziente: " + paziente);
		ResponseEntity<Object> responseEntity = null;
		if (paziente == null) {
			responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonObject("{'message': 'Empty Request'}"));
		}
		else if (Utils.isStringEmpty(paziente.getCodiceFiscale())) {
			responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonObject("{'messaggio': 'Dati obbligatori mancanti'}"));
		}
		else {
			Paziente pazienteResult = this.pazienteService.addPaziente(paziente);
			responseEntity = ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return responseEntity;
	}

}
