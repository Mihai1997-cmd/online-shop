package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.EnvironmentCapable;


@Configuration
//@ComponentScan
//@EnableAutoConfiguration
//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })


@ComponentScan({"com.controllers", "com.server.spring"})
//@EnableMongoRepositories ("com.server.repository") // this fix the problem
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(com.boot.Application.class, args);

    }

//    @Bean
//    CommandLineRunner init(UserRepository userRepository) {
//        return args -> {
//            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//                User user = new User(name, name.toLowerCase() + "@domain.com", "pwd");
//                userRepository.save(user);
//            });
//            userRepository.findAll().forEach(System.out::println);
//        };
//    }
}