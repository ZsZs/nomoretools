package com.nomoretools.fitnesse.user;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.nomoretools.fitnesse.application.IntegratedApplicationTester;

public class UserDatabaseHasRecordTest {
   @Before public void beforeEachTest(){
      IntegratedApplicationTester applicationTester = new IntegratedApplicationTester();
      applicationTester.configureUserService();
      applicationTester.setHost( "localhost" );
      applicationTester.setDataDriverClassName( "org.hsqldb.jdbc.JDBCDriver" );
   }
   
   @Test public void constructorUsesPreconfiguredIntegrationTester(){
      UserDatabaseHasRecord databaseHasRecord = new UserDatabaseHasRecord( "select * from account where ACCOUNT_NAME = 'zsolt'" );
      
      assertThat( databaseHasRecord.getServiceConfiguration(), notNullValue() );
      assertThat( databaseHasRecord.getDatabaseClient(), notNullValue() );
   }
}
