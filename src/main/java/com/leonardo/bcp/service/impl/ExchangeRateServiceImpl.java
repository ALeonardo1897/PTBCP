package com.leonardo.bcp.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leonardo.bcp.exception.NotFoundException;
import com.leonardo.bcp.model.entity.Currency;
import com.leonardo.bcp.model.entity.ExchangeRate;
import com.leonardo.bcp.model.request.RequestExchange;
import com.leonardo.bcp.model.request.RequestUpdateExchangeRate;
import com.leonardo.bcp.model.response.ResponseExchange;
import com.leonardo.bcp.model.response.ResponseUpdateExchangeRate;
import com.leonardo.bcp.repository.IExchangeRateRepository;
import com.leonardo.bcp.service.ICurrencyService;
import com.leonardo.bcp.service.IExchangeRateService;
import reactor.core.publisher.Mono;

@Service
public class ExchangeRateServiceImpl implements IExchangeRateService {

	@Autowired
	private IExchangeRateRepository exchangeRepository;

	@Autowired
	private ICurrencyService currencyService;

	@Override
	public Mono<ResponseExchange> processExchangeRate(RequestExchange request) {

		Mono<Currency> from = this.currencyService.findByName(request.getMonedaOrigen());
		Mono<Currency> to = this.currencyService.findByName(request.getMonedaDestino());
		
		Mono<ResponseExchange> response = Mono.zip(from, to)
				.flatMap( data -> this.exchangeRepository.findById( data.getT1().getId(), data.getT2().getId() ))
				.switchIfEmpty(Mono.error(new NotFoundException("ExchangeRateNotFound")))
				.flatMap( exchange -> Mono.just(new ResponseExchange(request.getMonto(), new BigDecimal(request.getMonto()*exchange.getValue()).setScale(2,RoundingMode.UP).doubleValue(), request.getMonedaOrigen(),request.getMonedaDestino(), exchange.getValue())));

		return response;
	}

	@Override
	public Mono<ResponseUpdateExchangeRate> updateExchangeRate(RequestUpdateExchangeRate request) {
		
		Mono<Currency> from = this.currencyService.findByName(request.getMonedaOrigen());
		Mono<Currency> to = this.currencyService.findByName(request.getMonedaDestino());
		
		Mono<ResponseUpdateExchangeRate> response = Mono.zip(from, to)
				.flatMap( data -> this.exchangeRepository.updateValueByIds( data.getT1().getId(), data.getT2().getId() , request.getTipoCambio() ))
				.flatMap( exchange -> Mono.just(new ResponseUpdateExchangeRate(true)));
		
		return response;
	}
	
	
	

}
