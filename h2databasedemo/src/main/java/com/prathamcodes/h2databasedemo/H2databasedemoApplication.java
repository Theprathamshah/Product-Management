package com.prathamcodes.h2databasedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("develop")
@ComponentScan("com.prathamcodes.h2databasedemo")
@EnableAspectJAutoProxy
public class H2databasedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2databasedemoApplication.class, args);
	}

}
