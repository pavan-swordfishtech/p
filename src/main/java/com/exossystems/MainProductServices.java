package com.exossystems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



	@SpringBootApplication
	@ComponentScan({"com.exossystems.*"})
	
	public class MainProductServices {
		public static void main(String[] args) {
			SpringApplication.run(MainProductServices.class, args);
		}
}
