package com.nomoretools.fitnesse.user;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.nomoretools.fitnesse.application.ServiceConfiguration;
import com.nomoretools.fitnesse.database.DatabaseClient;

@RunWith( SpringRunner.class )
@SpringBootTest( classes={ UserServiceConfiguration.class })
@EnableConfigurationProperties
@ActiveProfiles( "unit-test" )
public class UserServiceConfigurationTest {
   @Autowired ServiceConfiguration userServiceConfiguration;
   
   @Test public void autoconfiguration_selectsServiceSpecificProperties(){
      assertThat( userServiceConfiguration.getHost(), equalTo( "localhost" ));
      assertThat( userServiceConfiguration.getPort(), equalTo( "8082" ));
      assertThat( userServiceConfiguration.getContextPath(), equalTo( "" ));
   }
   
   @Test public void autoconfiguration_selectsNestedDataConfiguration(){
      assertThat( userServiceConfiguration.getDataSourceConfiguration(), notNullValue());
   }
         
   @Test public void createJdbcTemplate_configuresServerSpecificDataSource() throws SQLException{
      assertThat( userServiceConfiguration.createJdbcTemplate(), notNullValue() );
      assertThat( userServiceConfiguration.createJdbcTemplate().getDataSource(), notNullValue() );
      
      DataSource dataSource = userServiceConfiguration.createJdbcTemplate().getDataSource();
      assertThat( dataSource.toString(), containsString( "driverClassName=org.hsqldb.jdbc.JDBCDriver;" ));  
   }
   
   @Test public void createDatabaseClient_isConfigurationSpecific(){
      DatabaseClient databaseClient = userServiceConfiguration.createDatabaseClient();
      assertThat( databaseClient, notNullValue() );
      
      DataSource dataSource = databaseClient.getDataSource();
      assertThat( dataSource.toString(), containsString( "driverClassName=org.hsqldb.jdbc.JDBCDriver;" ));  
   }
}
