package com.disney.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;



@SpringBootApplication(scanBasePackages="com.disney")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching
public class StartApplication {
	
    public static void main (String[] args) {

        ApplicationContext ctx =
                    SpringApplication.run(StartApplication.class, args);     

    }
}