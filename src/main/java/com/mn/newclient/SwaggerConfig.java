package com.mn.newclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.Path;

@EnableSwagger2
@Configuration
public class SwaggerConfig  {

	/**
	 * @return
	 */
	@Bean
	public Docket detailApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.mn.newclient"))
		.build()
		.apiInfo(this.infoApi().build());

		//.paths(PathSelectors.any())

		return docket;
	}
	
	private ApiInfoBuilder infoApi() {
		ApiInfoBuilder appInfo  = new ApiInfoBuilder().title("Springboot + MongoDB");
		appInfo.description(" ");
		appInfo.version("1.0.0");

		return appInfo;
	}
}