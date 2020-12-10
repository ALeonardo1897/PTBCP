package com.leonardo.bcp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.leonardo.bcp.model.request.RequestExchange;
import com.leonardo.bcp.model.request.RequestUpdateExchangeRate;
import com.leonardo.bcp.model.response.ResponseExchange;
import com.leonardo.bcp.model.response.ResponseUpdateExchangeRate;
import com.leonardo.bcp.service.IExchangeRateService;
import com.leonardo.bcp.service.impl.ExchangeRateServiceImpl;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MainRestController {
	
	@Autowired
	private IExchangeRateService exchangeService;
	
	@PostMapping("/exchange")
	public Mono<ResponseExchange> exchangeRate(@RequestBody RequestExchange request) {
		return this.exchangeService.processExchangeRate(request);
	}
	
	@PostMapping("/exchange/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<ResponseUpdateExchangeRate> updateExchangeRate(@RequestBody RequestUpdateExchangeRate request) {
		return this.exchangeService.updateExchangeRate(request);
	}

}
