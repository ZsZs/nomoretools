package com.nomoretools.fitnesse.user;

import com.nomoretools.fitnesse.application.IntegratedApplicationTester;
import com.nomoretools.fitnesse.database.DatabaseHasRecord;

public class UserDatabaseHasRecord extends DatabaseHasRecord {
   
   // public accessor and mutator methods
   public UserDatabaseHasRecord(  String queryString ){
      super( IntegratedApplicationTester.getBean( UserServiceConfiguration.class ), queryString );
   }
   
   // protected, private helper methods
}
