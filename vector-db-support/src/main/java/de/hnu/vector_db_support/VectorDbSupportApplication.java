package de.hnu.vector_db_support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class VectorDbSupportApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(VectorDbSupportApplication.class, args);
	}

}
