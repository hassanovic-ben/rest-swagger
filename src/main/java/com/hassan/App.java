package com.hassan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EntityScan("com.hassan.model")
public class App {

    @Autowired
    private Environment env;

    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
  }

}
