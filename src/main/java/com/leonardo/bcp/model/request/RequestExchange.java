package com.leonardo.bcp.model.request;

import lombok.Data;

@Data
public class RequestExchange {

	private Double monto;
    private String monedaOrigen;
    private String monedaDestino;

}
