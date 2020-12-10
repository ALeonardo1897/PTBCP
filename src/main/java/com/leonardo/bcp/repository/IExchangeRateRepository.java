package com.leonardo.bcp.repository;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.leonardo.bcp.model.entity.ExchangeRate;
import reactor.core.publisher.Mono;

public interface IExchangeRateRepository extends ReactiveCrudRepository<ExchangeRate, Integer >{
	
	@Query("SELECT * FROM exchange_rate WHERE crncy_from = $1 AND crncy_to = $2")
	Mono<ExchangeRate> findById(int crncyFromId, int crncyToId);
	
	@Transactional
	@Modifying
	@Query("UPDATE exchange_rate SET value = $3 WHERE crncy_from = $1 AND crncy_to = $2")
	Mono<Integer> updateValueByIds(int crncyFromId, int crncyToId, double value);

}
