package com.leonardo.bcp.model.request;

import lombok.Data;

@Data
public class RequestUpdateExchangeRate {

	private String monedaOrigen;
    private String monedaDestino;
    private Double tipoCambio;
    
}
