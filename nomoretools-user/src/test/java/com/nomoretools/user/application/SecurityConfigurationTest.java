package com.nomoretools.user.application;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith( SpringRunner.class )
@SpringBootTest
@ActiveProfiles( "unit-test" )
@EnableConfigurationProperties
public class SecurityConfigurationTest {
   @Autowired SecurityConfig securityConfiguration;
   
   @Test public void configuresAnauthenticatedResources(){
      assertThat( securityConfiguration.getUnauthenticatedResources().size(), equalTo( 4 ));
   }
}
