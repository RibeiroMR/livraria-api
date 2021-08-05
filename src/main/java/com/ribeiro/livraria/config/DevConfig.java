package com.ribeiro.livraria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ribeiro.livraria.service.DBService;

@Configuration
@Profile("dev") /* definindo perfil de desenvolvimento */
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}") /* pegando valor definido na configuracao do arquivo application-dev.properties */
	private String strategy;

	@Bean
	public boolean instanciaBaseDeDados() {
		if (strategy.equals("create")) {
			this.dbService.instanciaBaseDeDados();
		}
		return false;
	}
}
