package com.nomoretools.fitnesse.user;

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
@SpringBootTest( classes={ UserServiceConfiguration.class })
@EnableConfigurationProperties
@ActiveProfiles( "unit-test" )
public class UserServiceConfigurationTest {
   @Autowired UserServiceConfiguration userServiceConfiguration;
   
   @Test public void autoconfiguration_selectsServiceSpecificProperties(){
      assertThat( userServiceConfiguration.getHost(), equalTo( "localhost" ));
      assertThat( userServiceConfiguration.getPort(), equalTo( "8082" ));
      assertThat( userServiceConfiguration.getContextPath(), equalTo( "" ));
   }
}
