package com.prova.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.prova.mongodb.model.Paziente;

public interface PazienteRepository extends MongoRepository<Paziente, String> {
	
	@Query("{'codice_fiscale': ?0}")
	public Paziente findByCodiceFiscale(String codiceFiscale);

}
