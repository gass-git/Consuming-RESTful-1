package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App {

	/* 
	 * The main() method is the starting point for JVM (Java Virtual Machine) 
	 * to start execution of a Java program. It only runs once.
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

	public static Logger log = LoggerFactory.getLogger(App.class);
	
	@Bean 
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Dog dog = restTemplate.getForObject(
				"https://dog.ceo/api/breeds/image/random",
				Dog.class
			);
			log.info(dog.getMessage());
		};
	}
}
