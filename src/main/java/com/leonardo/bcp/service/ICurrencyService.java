package com.leonardo.bcp.service;

import com.leonardo.bcp.model.entity.Currency;

import reactor.core.publisher.Mono;

public interface ICurrencyService {

	Mono<Currency> findByName(String name);
}
