package com.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tcs.clients.ClientRestController;

@SpringBootApplication
public class PaytmRestClientAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PaytmRestClientAppApplication.class, args);
		ClientRestController bean = context.getBean(ClientRestController.class);
		bean.invokeRestApi();
		context.close();
	}

}
