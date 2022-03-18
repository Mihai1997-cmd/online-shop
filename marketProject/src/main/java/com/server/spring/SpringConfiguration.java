package com.server.spring;

import com.server.sql.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories()
@ComponentScan({   "com.server", "com.models", "com.repositories",  "com.boot", "com.controllers"})
public class SpringConfiguration {

    @Autowired
    Environment env;

    @Bean
    public DatabaseManager databaseManager(){
        System.out.println(">>>>>>>>>>  database manager is created by config");
        return DatabaseManager.getInstance();
    }


}
