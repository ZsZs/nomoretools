package com.nomoretools.fitnesse.application;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith( SpringRunner.class )
@SpringBootTest( classes = { IntegratedApplicationTesterTest.class })
@EnableConfigurationProperties
public class IntegratedApplicationTesterTest {
   @Test public void initialize_createsConfigurationObjects(){
      IntegratedApplicationTester applicationTester = new IntegratedApplicationTester();
      
      applicationTester.initialize( "unit-test" );
      
      assertThat( applicationTester.getCoreServiceConfiguration(), notNullValue() );
      assertThat( applicationTester.getDocumentServiceConfiguration(), notNullValue() );
      assertThat( applicationTester.getFrontEndConfiguration(), notNullValue() );
      assertThat( applicationTester.getUserServiceConfiguration(), notNullValue() );
   }
   
   @Test public void initialize_createsApplicationContextWithProfile(){
      IntegratedApplicationTester applicationTester = new IntegratedApplicationTester();
      
      applicationTester.initialize( "unit-test" );
      
      assertThat( applicationTester.getUserServiceConfiguration().getHost(), equalTo( "localhost" ));
   }
}
