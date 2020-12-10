package com.leonardo.bcp.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseExchange {

	private Double monto;
    private Double montoTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private Double tipoCambio;
    
}
