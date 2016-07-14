package com.nomoretools.user.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories( basePackages = "com.nomoretools.user.integration" )
@EntityScan( basePackages = "com.nomoretools.user.domain" )
public class UserApplication {

   public static void main( String[] args ) {
      SpringApplication.run( UserApplication.class, args );
   }
}
