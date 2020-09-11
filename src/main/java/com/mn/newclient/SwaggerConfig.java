package com.mn.newclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;

@EnableSwagger2
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {

	/**
	 * @return
	 */
	@Bean
	public Docket detailApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.mn.newclient"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.infoApi().build());

		return docket;
	}
	
	private ApiInfoBuilder infoApi() {
		ApiInfoBuilder appInfo  = new ApiInfoBuilder().title("");
		appInfo.description(" ");
		appInfo.version("1.0.0");

		return appInfo;
	}
}