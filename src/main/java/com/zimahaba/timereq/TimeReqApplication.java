package com.zimahaba.timereq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.zimahaba.timereq.entity")
@EnableJpaRepositories(basePackages = "com.zimahaba.timereq.repository")
@ComponentScan(basePackages = "com.zimahaba.timereq")
public class TimeReqApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimeReqApplication.class, args);
	}
}
