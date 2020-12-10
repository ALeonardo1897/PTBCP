package com.leonardo.bcp.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("exchange_rate")
public class ExchangeRate {
	
	@Column("crncy_from")
	private int crncyFrom;
	
	@Column("crncy_to")
	private int crncyTo;
	
	@Column
	private double value;
	
}
