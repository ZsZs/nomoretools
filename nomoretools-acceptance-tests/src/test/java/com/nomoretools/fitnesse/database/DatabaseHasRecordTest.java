package com.nomoretools.fitnesse.database;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.nomoretools.fitnesse.application.IntegratedApplicationTester;
import com.nomoretools.fitnesse.user.UserDatabaseHasRecord;

@RunWith( SpringRunner.class )
@SpringBootTest( classes = { IntegratedApplicationTester.class })
@EnableConfigurationProperties
@ActiveProfiles( "unit-test" )
public class DatabaseHasRecordTest {
   private DatabaseHasRecord databaseHasRecord;

   @Before public void beforeEachTest(){
//      IntegratedApplicationTester applicationTester = new IntegratedApplicationTester();
//      applicationTester.initialize();
      
      databaseHasRecord = new UserDatabaseHasRecord( "select * from account" );
   }
   
   @Test public void query_returnsRecordsAsListOfString() {
      assertThat( databaseHasRecord.query().size(), equalTo( 2 ));
   }
   
}
