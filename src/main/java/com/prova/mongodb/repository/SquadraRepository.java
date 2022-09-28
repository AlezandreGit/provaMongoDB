package com.prova.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prova.mongodb.model.Squadra;

public interface SquadraRepository extends MongoRepository<Squadra, String> {

}
