package com.leonardo.bcp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
@EnableR2dbcRepositories
public class DatabaseConfig extends AbstractR2dbcConfiguration{

	@Bean
	@Override
	public ConnectionFactory connectionFactory() {
		return new H2ConnectionFactory(
	            H2ConnectionConfiguration.builder()
	              .url("mem:bcpdb;DB_CLOSE_DELAY=-1;")
	              .username("sa")
	              .build()
	        );
	}
	
}
