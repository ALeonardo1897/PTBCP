package com.leonardo.bcp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leonardo.bcp.exception.NotFoundException;
import com.leonardo.bcp.model.entity.Currency;
import com.leonardo.bcp.repository.ICurrencyRepository;
import com.leonardo.bcp.service.ICurrencyService;

import reactor.core.publisher.Mono;

@Service
public class CurrencyServiceImpl implements ICurrencyService{

	@Autowired
	private ICurrencyRepository currencyRepository;
	
	@Override
	public Mono<Currency> findByName(String name) {
		return this.currencyRepository.findByName(name)
				.switchIfEmpty(Mono.error(new NotFoundException("CurrencyNotFound: " + name)));
	}

	
	
}
