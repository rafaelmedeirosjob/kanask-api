package com.supero.kanask.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.supero.kanask.model.Task;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Configurations {
	@Bean
	public Docket challengeApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.indra.challenge"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.ignoredParameterTypes(Task.class);
	}
}