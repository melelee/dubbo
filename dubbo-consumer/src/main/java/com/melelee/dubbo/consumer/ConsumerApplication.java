package com.melelee.dubbo.consumer;

import com.melelee.dubbo.common.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@Slf4j
public class ConsumerApplication {


	@Reference
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class).close();
	}

	@Bean
	public ApplicationRunner runner() {
		return args -> userService.saveUser("mercyblitz");
	}
}

