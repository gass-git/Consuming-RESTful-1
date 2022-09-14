package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
 * @SpringBootApplication annotation is used to mark a configuration 
 * class that declares one or more @Bean methods and also triggers 
 * auto-configuration and component scanning.
 */
@SpringBootApplication
public class App {
	public static Logger log = LoggerFactory.getLogger(App.class);

	/* 
	 * The main() method:
	 * is the starting point for JVM (Java Virtual Machine) 
	 * to start execution of a Java program. It only runs once. It is globaly
	 * available.
	 * 
	 * it can be thought out as a method that is outside the main class.
	 */
	public static void main(String[] args){
		
		/* 	
		 * .class references the App class literal object, that
		 * represents information about the given class.
		 * 
		 * App.class is an object that represents the class App on runtime.
		 * It is the same object that is returned by the getClass() method 
		 * of any (direct) instance of App.
		 */
		SpringApplication.run(App.class, args);
    }   
	
	/*
	 * @Bean: 
	 * instance of a class managed by the Spring container.
	 *
	 * Spring container: 
	 * is part of the core of the Spring framework and is responsible for
	 * managing all the beans. Creates the intances and it makes sure that they
	 * are in the right place and the right time to run the application.
	 * 
	 */
	@Bean 
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return (args) -> {
			Dog dog = restTemplate.getForObject(
				"https://dog.ceo/api/breeds/image/random",
				Dog.class
			);
			log.info(dog.toString());
		};
	}
}
