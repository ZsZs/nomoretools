package com.nomoretools.fitnesse.user;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties( prefix = "user-service" )
public class UserServiceConfiguration {
   private String contextPath;
   private String host;
   private String port;
   
   // properties
   // @formatter:off
   public String getContextPath() { return contextPath; }
   public String getHost() { return host; }
   public String getPort() { return port; }
   public void setContextPath( String contextPath ) { this.contextPath = contextPath; }
   public void setHost( String host ) { this.host = host; }
   public void setPort( String port ) { this.port = port; }
   // @formatter:on
   
}
