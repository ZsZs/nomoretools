package com.nomoretools.fitnesse.database;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseClient {
   private final JdbcTemplate jdbc;

   public DatabaseClient( JdbcTemplate jdbc ) {
      this.jdbc = jdbc;
   }

   public List<Map<String, Object>> query( String sql ) {
      return jdbc.queryForList( sql );
   }

   // properties
   // @formatter:off
   public DataSource getDataSource() { return jdbc.getDataSource(); }
   // @formatter:on
}
