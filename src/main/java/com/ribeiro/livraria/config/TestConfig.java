package com.ribeiro.livraria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ribeiro.livraria.service.DBService;

@Configuration
@Profile("test") /* definindo perfil de teste */
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public void instanciaBaseDeDados() {
		this.dbService.instanciaBaseDeDados();
	}
}
