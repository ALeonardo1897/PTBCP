package com.leonardo.bcp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import io.r2dbc.spi.ConnectionFactory;

@Configuration
public class DatabaseInit {
	
	@Autowired
	private ConnectionFactory connectionFactory;

	@Bean
	public ConnectionFactoryInitializer initializer() {
		
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		
		CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
		populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("db-schema.sql")));
		populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("db-data.sql")));
		
		initializer.setDatabasePopulator(populator);
		
		return initializer;
	}
	
}
