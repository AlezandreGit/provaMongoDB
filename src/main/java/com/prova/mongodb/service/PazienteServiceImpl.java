package com.prova.mongodb.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova.mongodb.exception.ApplicationException;
import com.prova.mongodb.model.Paziente;
import com.prova.mongodb.repository.PazienteRepository;
import com.prova.mongodb.utils.Constants;

@Service
public class PazienteServiceImpl implements PazienteService {

	private static final Logger LOGGER = LogManager.getLogger(PazienteServiceImpl.class);

	private PazienteRepository pazienteRepository;
	
	
	@Autowired
	public PazienteServiceImpl(PazienteRepository pazienteRepository) {
		this.pazienteRepository = pazienteRepository;
	}
	
	public List<Paziente> getAllPazienti() {
		return pazienteRepository.findAll();
	}
	
	public Paziente getPaziente(String codiceFiscale) {
		return pazienteRepository.findByCodiceFiscale(codiceFiscale);
	}
	
	public Paziente addPaziente(Paziente paziente) throws ApplicationException {
		Paziente pazienteResult;
		try {
			pazienteResult = pazienteRepository.insert(paziente);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new ApplicationException(Constants.INTERNAL_SERVER_ERROR_INT, e.getMessage(), e);
//			throw e;
		}
		return pazienteResult;
	}
	
}
