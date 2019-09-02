package com.imuka.imuka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import com.imuka.imuka.config.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ImukaApplication {
	//@Bean
    //public Java8TimeDialect java8TimeDialect() {
      //  return new Java8TimeDialect();
    //}

	public static void main(String[] args) {
		SpringApplication.run(ImukaApplication.class, args);
	}

}
