package com.leonardo.bcp.repository;

import java.util.Optional;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.leonardo.bcp.model.entity.Currency;

import reactor.core.publisher.Mono;

public interface ICurrencyRepository extends ReactiveCrudRepository<Currency, Integer>{

	//@Query("SELECT * FROM currency WHERE name = $1")
	Mono<Currency> findByName(String name);
	
}
