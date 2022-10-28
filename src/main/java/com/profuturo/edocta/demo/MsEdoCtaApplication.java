package com.profuturo.edocta.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@SpringBootApplication
@EnableTransactionManagement
public class MsEdoCtaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEdoCtaApplication.class, args);
	}

}
