package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.Scanner;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
		// load the Spring context
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

		// get the reference to the message channel
		MessageChannel channel = context.getBean("inputChannel", MessageChannel.class);


		// create a message with the content "World"
		Message<String> message = MessageBuilder.withPayload(askQuestion()).build();

		// send the message to the inputChannel
		channel.send(message);
	}

	public static String askQuestion(){
		System.out.println("Please input your name:");
		Scanner vstup = new Scanner(System.in);
		String name = vstup.next();
		return name;
	}

}
