package com.leonardo.bcp.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("currency")
public class Currency {
	
	@Id
	@Column
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String symbol;
	

}
