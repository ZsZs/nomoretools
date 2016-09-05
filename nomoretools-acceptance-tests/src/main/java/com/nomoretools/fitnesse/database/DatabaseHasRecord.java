package com.nomoretools.fitnesse.database;

import static java.util.Arrays.asList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseHasRecord {
   @Autowired private DatabaseClient databaseClient;
   private List<List<List<String>>> queryResult;
   private String query;
   
   public DatabaseHasRecord( String queryString ){
      this.query = queryString;
      databaseClient = new DatabaseClient();
   }
   
   public List<List<List<String>>> query() {
      List<String> resultList = databaseClient.query( query );

      return
        asList( // table level
          asList( // row level
            asList("name", "john"), // cell column name, value
            asList("password", "john")
          )
        );
    }   
}
