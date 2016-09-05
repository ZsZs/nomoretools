package com.nomoretools.fitnesse.database;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JdbcTemplate.class)
public class DatabaseHasRecordTest {
   private DatabaseHasRecord databaseHasRecord;
   
   @Test public void query_returnsRecordsAsListOfString(){
      databaseHasRecord = new DatabaseHasRecord( "select * from user" );
      assertThat( databaseHasRecord.query().size(), equalTo( 1  ));
   }
}
