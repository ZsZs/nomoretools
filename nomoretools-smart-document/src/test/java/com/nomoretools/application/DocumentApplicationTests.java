package com.nomoretools.application;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest( webEnvironment=WebEnvironment.RANDOM_PORT )
public class DocumentApplicationTests {

   @Value( "${local.server.port}" )
   private int port;

   @Test
   public void getDiscipline() throws Exception {
      String url = "http://localhost:" + this.port + "/documents/0";
      ResponseEntity<String> entity = new TestRestTemplate().getForEntity( url, String.class );
      assertThat( entity.getStatusCode(), equalTo( HttpStatus.OK ) );
      assertThat( entity.getBody(), containsString( "Requirements" ) );
   }
}
