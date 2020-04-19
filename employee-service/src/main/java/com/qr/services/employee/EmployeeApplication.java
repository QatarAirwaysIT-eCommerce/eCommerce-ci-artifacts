package com.qr.services.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.qr.services.employee.model.Employee;
import com.qr.services.employee.repository.EmployeeRepository;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class EmployeeApplication {

	public static void main(String[] args) {
		//System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.qr.services.employee.controller"))
				.paths(PathSelectors.any()).build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Employee API")
						.description("Documentation for Employee REST API v1.0")
						.contact(new Contact("Suresh babu KVS", "www.qatarairways.com", "sureshbabu@qatarairways.com.qa")).build());
	}

	@Bean
	UiConfiguration uiConfig() {
		return UiConfigurationBuilder.builder().deepLinking(true).displayOperationId(false).defaultModelsExpandDepth(1)
				.defaultModelExpandDepth(1).defaultModelRendering(ModelRendering.EXAMPLE).displayRequestDuration(false)
				.docExpansion(DocExpansion.NONE).filter(false).maxDisplayedTags(null)
				.operationsSorter(OperationsSorter.ALPHA).showExtensions(false).tagsSorter(TagsSorter.ALPHA)
				.supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS).validatorUrl(null).build();
	}

	@Bean
	EmployeeRepository repository() {
		EmployeeRepository repository = new EmployeeRepository();
		repository.add(new Employee(1L, 1L, "Suresh Babu KVS", 41, "Analyst"));
		repository.add(new Employee(1L, 1L, "Manikantan Vannadil Puthiyaveettil", 44, "Manager"));
		repository.add(new Employee(1L, 1L, "Kavitha Sunil", 28, "Developer"));
		repository.add(new Employee(1L, 2L, "Tino Mulanchira Thomas", 32, "Analyst"));
		repository.add(new Employee(1L, 2L, "Philip George Panickar", 28, "Developer"));
		repository.add(new Employee(2L, 3L, "Ashok Yalakapati", 30, "Developer"));
		repository.add(new Employee(2L, 3L, "Shibu Kuppelan", 30, "Developer"));
		repository.add(new Employee(2L, 3L, "Shanib Karuvattuparamb Kunhimon", 30, "Manager"));
		repository.add(new Employee(2L, 4L, "Anikuttan Sukumara Pillai", 35, "Manager"));
		repository.add(new Employee(2L, 4L, "Priyanka Prakash", 35, "Tester"));
		return repository;
	}

}
