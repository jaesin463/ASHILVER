package com.ssafy.pjt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.pjt.controller"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SSAFY 10기 ASHILVER PJT REST API")
				.description("ashilver 서버")
				.version("0.1")
				.build();
	}
	
//	 utf-8로 변환하려다 실패
	@Bean
	public ResourceBundleMessageSource translator() {
	    ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	    source.setBasenames("swagger-message");
	    source.setUseCodeAsDefaultMessage(true);
	    source.setDefaultEncoding("utf-8");
	    return source;
	}
}
