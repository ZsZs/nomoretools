package com.nomoretools.fitnesse.application;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;

import com.nomoretools.fitnesse.application.ServiceConfiguration.DataSourceConfiguration;
import com.nomoretools.fitnesse.core.CoreServiceConfiguration;
import com.nomoretools.fitnesse.document.DocumentServiceConfiguration;
import com.nomoretools.fitnesse.frontend.FrontEndServiceConfiguration;
import com.nomoretools.fitnesse.user.UserServiceConfiguration;

@SpringBootApplication
@ComponentScan( basePackages = {"com.nomoretools.fitnesse.application", "com.nomoretools.fitnesse.database", "com.nomoretools.fitnesse.core", "com.nomoretools.fitnesse.document", "com.nomoretools.fitnesse.frontend", "com.nomoretools.fitnesse.user" })
@EnableConfigurationProperties
public class IntegratedApplicationTester implements ApplicationContextAware{
   private static ApplicationContext applicationContext;
   private static IntegratedApplicationTester soleInstance;
   @Autowired private CoreServiceConfiguration coreServiceConfiguration;
   @Autowired private ServiceConfiguration currentConfiguration;
   @Autowired private DocumentServiceConfiguration documentServiceConfiguration;
   @Autowired private FrontEndServiceConfiguration frontEndConfiguration;
   @Autowired private ServiceConfiguration userServiceConfiguration;

   // constructors
   public IntegratedApplicationTester(){
      soleInstance = this;
   }
   
   // public accessors and mutators
   public void configureCoreService(){
      coreServiceConfiguration = new CoreServiceConfiguration();
      coreServiceConfiguration.setDataSourceConfiguration( new DataSourceConfiguration() );
      currentConfiguration = coreServiceConfiguration;
   }
   
   public void configureUserService(){
      userServiceConfiguration = new UserServiceConfiguration();
      userServiceConfiguration.setDataSourceConfiguration( new DataSourceConfiguration() );
      currentConfiguration = userServiceConfiguration;
   }
   
   public static void main( String[] args ) {
      applicationContext = SpringApplication.run( IntegratedApplicationTester.class, args );
      soleInstance = getBean( IntegratedApplicationTester.class );
   }

   public void initialize( String activeProfile ) {
      applicationContext = SpringApplication.run( IntegratedApplicationTester.class, new String[]{ "--spring.profiles.active=" + activeProfile } );
      soleInstance = getBean( IntegratedApplicationTester.class );
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
   public static IntegratedApplicationTester getInstance() { return soleInstance; }
   public ServiceConfiguration getUserServiceConfiguration() { return userServiceConfiguration; }
   @Override public void setApplicationContext( ApplicationContext context ) throws BeansException { applicationContext = context; }
   public void setContextPath( String contextPath ){ currentConfiguration.setContextPath( contextPath ); }
   public void setDataDriverClassName( String dataDriverClassName ){ currentConfiguration.setDataDriverClassName( dataDriverClassName ); }
   public void setDataPassword( String dataPassword ){ currentConfiguration.setDataPassword( dataPassword ); }
   public void setDataUrl( String dataUrl ){ currentConfiguration.setDataUrl( dataUrl ); }
   public void setDataUserName( String dataUserName ){ currentConfiguration.setDataUserName( dataUserName ); }
   public void setPort( String port ){ currentConfiguration.setPort( port ); }
   public void setHost( String host ){ currentConfiguration.setHost( host ); }
   // @formatter:on
}
