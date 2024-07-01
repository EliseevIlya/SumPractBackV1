package com.example.sumpractbackv1;

import com.example.sumpractbackv1.Services.XmlToDatabase;
import com.example.sumpractbackv1.Services.test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SumPractBackV1Application {

	public static void main(String[] args) {
		SpringApplication.run(SumPractBackV1Application.class, args);

	}

}
