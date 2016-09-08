package com.nomoretools.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories( basePackages = "com.nomoretools.document.integration" )
@EntityScan( basePackages = "com.nomoretools.document.domain" )
public class DocumentApplication {

   public static void main( String[] args ) {
      SpringApplication.run( DocumentApplication.class, args );
   }
}
