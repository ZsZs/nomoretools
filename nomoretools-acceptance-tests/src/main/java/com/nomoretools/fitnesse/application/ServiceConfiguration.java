package com.nomoretools.fitnesse.application;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.nomoretools.fitnesse.database.DatabaseClient;

public abstract class ServiceConfiguration {
   protected String contextPath;
   protected String host;
   @NestedConfigurationProperty protected DataSourceConfiguration dataSourceConfiguration;
   protected String port;

   // public accessors and mutators
   public DatabaseClient createDatabaseClient() {
      return new DatabaseClient( this.createJdbcTemplate() );
   }
   
   public JdbcTemplate createJdbcTemplate() {
      DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
      dataSourceBuilder.url( dataSourceConfiguration.getUrl() );
      dataSourceBuilder.username( dataSourceConfiguration.getUsername() );
      dataSourceBuilder.password( dataSourceConfiguration.getPassword() );
      DataSource dataSource = dataSourceBuilder.build(); 
      return new JdbcTemplate( dataSource );
   }
   
   // properties
   // @formatter:off
   public String getContextPath() { return contextPath; }
   public String getHost() { return host; }
   public String getPort() { return port; }
   public void setContextPath( String contextPath ) { this.contextPath = contextPath; }
   public void setHost( String host ) { this.host = host; }
   public DataSourceConfiguration getDataSourceConfiguration() { return dataSourceConfiguration; }
   public void setDataDriverClassName( String dataDriverClassName ) { this.dataSourceConfiguration.setDriverClassName( dataDriverClassName ); }
   public void setDataPassword( String dataPassword ) { this.dataSourceConfiguration.setPassword( dataPassword ); }
   public void setDataSourceConfiguration( DataSourceConfiguration dataSourceConfiguration ) { this.dataSourceConfiguration = dataSourceConfiguration; }
   public void setDataUrl( String dataUrl ) { this.dataSourceConfiguration.setUrl( dataUrl ); }
   public void setDataUserName( String dataUserName ) { this.dataSourceConfiguration.setUsername( dataUserName ); }
   public void setPort( String port ) { this.port = port; }
   // @formatter:on
   
   @Component public static class DataSourceConfiguration {
      protected String driverClassName;
      protected String url;
      protected String username;
      protected String password;

      // properties
      // @formatter:off
      public String getDriverClassName() { return driverClassName; }
      public String getPassword() { return password; }
      public String getUrl() { return url; }
      public String getUsername() { return username; }
      public void setUsername( String username ) { this.username = username; }
      public void setDriverClassName( String driverClassName ) { this.driverClassName = driverClassName; }
      public void setPassword( String password ) { this.password = password; }
      public void setUrl( String url ) { this.url = url; }
      // formatter:on
  }

}
