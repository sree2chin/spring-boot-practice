package io.datajek.springdata.tennisplayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// db can be accessed at localhost:8080/h2-console
@SpringBootApplication
public class TennisPlayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisPlayerApplication.class, args);
	}

}
