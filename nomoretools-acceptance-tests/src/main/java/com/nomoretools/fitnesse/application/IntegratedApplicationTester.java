package com.nomoretools.fitnesse.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.nomoretools.fitnesse.core.CoreServiceConfiguration;
import com.nomoretools.fitnesse.database.DatabaseHasRecord;
import com.nomoretools.fitnesse.document.DocumentServiceConfiguration;
import com.nomoretools.fitnesse.frontend.FrontEndServiceConfiguration;
import com.nomoretools.fitnesse.user.UserServiceConfiguration;

@SpringBootApplication
@ComponentScan( basePackages = {"com.nomoretools.fitnesse.application", "com.nomoretools.fitnesse.database"} )
@EnableConfigurationProperties
public class IntegratedApplicationTester {
   @Autowired private CoreServiceConfiguration coreServiceConfiguration;
   @Autowired private DatabaseHasRecord databaseHasRecord;
   @Autowired private DocumentServiceConfiguration documentServiceConfiguration;
   @Autowired private FrontEndServiceConfiguration frontEndConfiguration;
   @Autowired private UserServiceConfiguration userServiceConfiguration;

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
   // @formatter:off
   public CoreServiceConfiguration getCoreServiceConfiguration() { return coreServiceConfiguration; }
   public DatabaseHasRecord getDatabaseHasRecord() { return databaseHasRecord; }
   public DocumentServiceConfiguration getDocumentServiceConfiguration(){ return documentServiceConfiguration; }
   public FrontEndServiceConfiguration getFrontEndConfiguration() { return frontEndConfiguration; }
   public UserServiceConfiguration getUserServiceConfiguration() { return userServiceConfiguration; }
}
