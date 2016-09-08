package com.nomoretools.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories( basePackages = "com.nomoretools.discipline.integration" )
@EntityScan( basePackages = "com.nomoretools.discipline.domain" )
public class CoreApplication {

   public static void main( String[] args ) {
      SpringApplication.run( CoreApplication.class, args );
   }
}
