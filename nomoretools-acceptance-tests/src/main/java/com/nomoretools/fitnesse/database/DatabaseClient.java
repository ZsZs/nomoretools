package com.nomoretools.fitnesse.database;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseClient {
   private final JdbcTemplate jdbc;

   @Autowired public DatabaseClient( JdbcTemplate jdbc ) {
      this.jdbc = jdbc;
   }

   public List<Map<String, Object>> query( String sql ) {
      return jdbc.queryForList( sql );
   }
}
