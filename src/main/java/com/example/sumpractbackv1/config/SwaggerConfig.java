package com.example.sumpractbackv1.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi adminApi() {
		return GroupedOpenApi.builder()
				.group("admin")
				.pathsToMatch("/**")
				.build();
	}

	@Bean
	public OpenAPI openApi() {
		return new OpenAPI()
				.info(new io.swagger.v3.oas.models.info.Info()
						.title("SumPract API")
						.version("1.0.0")
						.description("SumPract API")
				).addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
				.components(new Components().addSecuritySchemes(
						"BearerAuth",
						new SecurityScheme()
								.type(SecurityScheme.Type.HTTP)
								.scheme("bearer")
								.bearerFormat("JWT")
				));
	}
	
}
