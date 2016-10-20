package com.nomoretools.user.application;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith( SpringRunner.class )
@SpringBootTest
@Category( UserServiceIntegratedTest.class )
@ActiveProfiles( "local" )
public class IntegratedUserApplicationTest {
   @Autowired DataSource dataSource;
   
   @Test public void applicationUsesSharedDatabaseServer() {
      assertThat( dataSource, notNullValue() );
      assertThat( dataSource.toString(), containsString( "driverClassName=org.hsqldb.jdbc.JDBCDriver;" ));  
      assertThat( dataSource.toString(), containsString( "url=jdbc:hsqldb:hsql://localhost/user_test_db;" ));  
   }
}
