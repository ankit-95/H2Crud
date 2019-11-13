package com.h2.H2Crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.Collections;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.h2.controller"))
	      .paths(PathSelectors.ant("/rest/**"))
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "H2 Crud Operation", 
	      "CRUD Operations", 
	      "API TOS", 
	      "Terms of service", 
	      new Contact("Ankit Gupta", "www.example.com", "myeaddress@company.com"), 
	      "License of API", "API license URL", java.util.Collections.EMPTY_LIST);
	}
	 
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	     registry.addResourceHandler("swagger-ui.html")
	       .addResourceLocations("classpath:/META-INF/resources/");
	  
	     registry.addResourceHandler("/webjars/**")
	       .addResourceLocations("classpath:/META-INF/resources/webjars/");
	 }
}
