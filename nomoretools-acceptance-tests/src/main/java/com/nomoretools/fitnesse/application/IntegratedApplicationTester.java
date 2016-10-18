package com.nomoretools.fitnesse.application;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;

import com.nomoretools.fitnesse.core.CoreServiceConfiguration;
import com.nomoretools.fitnesse.document.DocumentServiceConfiguration;
import com.nomoretools.fitnesse.frontend.FrontEndServiceConfiguration;
import com.nomoretools.fitnesse.user.UserServiceConfiguration;

@SpringBootApplication
@ComponentScan( basePackages = {"com.nomoretools.fitnesse.application", "com.nomoretools.fitnesse.database", "com.nomoretools.fitnesse.core", "com.nomoretools.fitnesse.document", "com.nomoretools.fitnesse.frontend", "com.nomoretools.fitnesse.user" })
@EnableConfigurationProperties
public class IntegratedApplicationTester implements ApplicationContextAware{
   private static ApplicationContext applicationContext;
   @Autowired private CoreServiceConfiguration coreServiceConfiguration;
   @Autowired private DocumentServiceConfiguration documentServiceConfiguration;
   @Autowired private FrontEndServiceConfiguration frontEndConfiguration;
   @Autowired private ServiceConfiguration userServiceConfiguration;

   // public accessors and mutators
   public static void main( String[] args ) {
      applicationContext = SpringApplication.run( IntegratedApplicationTester.class, args );
   }

   public void initialize( String activeProfile ) {
      applicationContext = SpringApplication.run( IntegratedApplicationTester.class, new String[]{ "--spring.profiles.active=" + activeProfile } );
      coreServiceConfiguration = getBean( CoreServiceConfiguration.class );
      documentServiceConfiguration = getBean( DocumentServiceConfiguration.class );
      frontEndConfiguration = getBean( FrontEndServiceConfiguration.class );
      userServiceConfiguration = getBean( UserServiceConfiguration.class );
   }


   // properties
   // @formatter:off
   public static <T> T getBean( Class<T> requiredType ){ return applicationContext.getBean( requiredType ); }
   public CoreServiceConfiguration getCoreServiceConfiguration() { return coreServiceConfiguration; }
   public DocumentServiceConfiguration getDocumentServiceConfiguration(){ return documentServiceConfiguration; }
   public FrontEndServiceConfiguration getFrontEndConfiguration() { return frontEndConfiguration; }
   public ServiceConfiguration getUserServiceConfiguration() { return userServiceConfiguration; }
   @Override public void setApplicationContext( ApplicationContext context ) throws BeansException { applicationContext = context; }
   // @formatter:on
}
