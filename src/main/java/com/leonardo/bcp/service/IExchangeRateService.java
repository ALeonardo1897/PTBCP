package com.leonardo.bcp.service;

import com.leonardo.bcp.model.entity.Currency;
import com.leonardo.bcp.model.entity.ExchangeRate;
import com.leonardo.bcp.model.request.RequestExchange;
import com.leonardo.bcp.model.request.RequestUpdateExchangeRate;
import com.leonardo.bcp.model.response.ResponseExchange;
import com.leonardo.bcp.model.response.ResponseUpdateExchangeRate;

import reactor.core.publisher.Mono;

public interface IExchangeRateService {

	Mono<ResponseExchange> processExchangeRate(RequestExchange request);
	
	Mono<ResponseUpdateExchangeRate> updateExchangeRate(RequestUpdateExchangeRate request);
	
}
