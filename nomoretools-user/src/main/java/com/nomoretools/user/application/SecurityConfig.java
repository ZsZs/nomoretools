package com.nomoretools.user.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.google.common.collect.Lists;

@Configuration
@ConfigurationProperties( prefix = "security" )
@EnableGlobalAuthentication
public class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {
   @Autowired private UserDetailsService userDetailsService;
   List<String> unauthenticatedResources = Lists.newArrayList();

   @Override public void init( AuthenticationManagerBuilder auth ) throws Exception {
      auth.userDetailsService( this.userDetailsService );
   }

   // properties
   // @formatter:off
   public List<String> getUnauthenticatedResources() { return unauthenticatedResources; }
   public UserDetailsService getUserDetailsService() { return userDetailsService; }
   public void setUnauthenticatedResources( List<String> unauthenticatedResources ) { this.unauthenticatedResources = unauthenticatedResources; }
   // @formatter:on
}
