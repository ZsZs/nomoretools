package com.nomoretools.fitnesse.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseClient {
   @Autowired JdbcTemplate jdbcTemplate;

   public List<String> query( String sql ){
      return jdbcTemplate.queryForList( sql, String.class );
   }
}
