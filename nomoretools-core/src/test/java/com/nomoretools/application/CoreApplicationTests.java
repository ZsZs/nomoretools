package com.nomoretools.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration( classes = CoreApplication.class )
@WebIntegrationTest( randomPort = true )
public class CoreApplicationTests {

   @Value( "${local.server.port}" )
   private int port;

   @Test
   public void getDiscipline() throws Exception {
      String url = "http://localhost:" + this.port + "/disciplines/0";
      ResponseEntity<String> entity = new TestRestTemplate().getForEntity( url, String.class );
      assertThat( entity.getStatusCode(), equalTo( HttpStatus.OK ) );
      assertThat( entity.getBody(), containsString( "Requirements" ) );
   }
}
