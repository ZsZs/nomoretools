package com.nomoretools.fitnesse.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.nomoretools.fitnesse.database.DatabaseHasRecord;

@SpringBootApplication
@ComponentScan( basePackages = {"com.nomoretools.fitnesse.application", "com.nomoretools.fitnesse.database"} )
public class IntegratedApplicationTester {
   @Autowired private DatabaseHasRecord databaseHasRecord;

   // public accessors and mutators
   public DatabaseHasRecord databaseHasRecord( String sql ) {
      databaseHasRecord.setSql( sql );
      return databaseHasRecord;
   }

   public static void main( String[] args ) {
      SpringApplication.run( IntegratedApplicationTester.class, args );
   }

   public void initialize() {
      SpringApplication.run( IntegratedApplicationTester.class );
   }

   // properties
}
