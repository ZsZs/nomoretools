package com.nomoretools.fitnesse.application;

public abstract class ServiceConfiguration {
   protected String contextPath;
   protected String host;
   protected String port;
   
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
