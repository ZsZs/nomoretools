package com.nomoretools.fitnesse;

import java.util.List;
import static java.util.Arrays.asList;

public class DatabaseHasRecord {

   public DatabaseHasRecord( String queryString ){
      
   }
   
   public List<List<List<String>>> query() {

      return
        asList( // table level
          asList( // row level
            asList("name", "john"), // cell column name, value
            asList("password", "john")
          )
        );
    }   
}
