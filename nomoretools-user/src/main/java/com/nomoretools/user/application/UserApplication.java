/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nomoretools.user.application;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CompositeFilter;

@SpringBootApplication
@RestController
@EnableOAuth2Client
@EnableAuthorizationServer
@EnableWebSecurity
@Order( 6 )
public class UserApplication extends WebSecurityConfigurerAdapter {
   @Autowired OAuth2ClientContext oauth2ClientContext;

   @Bean @ConfigurationProperties( "facebook" ) public ClientResources facebook() {
      return new ClientResources();
   }

   @Bean @ConfigurationProperties( "github" ) public ClientResources github() {
      return new ClientResources();
   }

   public static void main( String[] args ) {
      SpringApplication.run( UserApplication.class, args );
   }

   @Bean public FilterRegistrationBean oauth2ClientFilterRegistration( OAuth2ClientContextFilter filter ) {
      FilterRegistrationBean registration = new FilterRegistrationBean();
      registration.setFilter( filter );
      registration.setOrder( -100 );
      return registration;
   }

   @RequestMapping( "/unauthenticated" ) public String unauthenticated() {
      return "redirect:/?error=true";
   }

   @RequestMapping( { "/user", "/me" } ) public Map<String, String> user( Principal principal ) {
      Map<String, String> map = new LinkedHashMap<>();
      map.put( "name", principal.getName() );
      return map;
   }

   @Bean UserDetailsService userDetailsService( JdbcTemplate jdbcTemplate ) {
      // @formatter:off
      RowMapper<User> userDetailsRowMapper = ( rs, i ) -> 
         new User( rs.getString( "ACCOUNT_NAME" ), 
                   rs.getString( "PASSWORD" ), 
                   rs.getBoolean( "ENABLED" ), 
                   rs.getBoolean( "ENABLED" ),
                   rs.getBoolean( "ENABLED" ), 
                   rs.getBoolean( "ENABLED" ), 
                   AuthorityUtils.createAuthorityList( "ROLE_USER", "ROLE_ADMIN" ) );
         
      return username -> jdbcTemplate.queryForObject( "select * from ACCOUNT where ACCOUNT_NAME = ?", userDetailsRowMapper, username );
      // @formatter:on
   }

   @Configuration
   @EnableResourceServer
   protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
      @Override public void configure( HttpSecurity http ) throws Exception {
         // @formatter:off
         http.antMatcher("/me").authorizeRequests().anyRequest().authenticated();
         // @formatter:on
      }
   }

   @Configuration
   protected static class ServletCustomizer {
      @Bean public EmbeddedServletContainerCustomizer customizer() {
         return container -> {
            container.addErrorPages( new ErrorPage( HttpStatus.UNAUTHORIZED, "/unauthenticated" ) );
         };
      }
   }

   // protected, private helper methods
   @Override protected void configure( HttpSecurity http ) throws Exception {
      // @formatter:off
        http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**").permitAll().anyRequest()
                .authenticated().and().exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/")).and().logout()
                .logoutSuccessUrl("/").permitAll().and().csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
        // @formatter:on
   }

   private Filter ssoFilter() {
      CompositeFilter filter = new CompositeFilter();
      List<Filter> filters = new ArrayList<>();
      filters.add( ssoFilter( facebook(), "/login/facebook" ) );
      filters.add( ssoFilter( github(), "/login/github" ) );
      filter.setFilters( filters );
      return filter;
   }

   private Filter ssoFilter( ClientResources client, String path ) {
      OAuth2ClientAuthenticationProcessingFilter oAuth2ClientAuthenticationFilter = new OAuth2ClientAuthenticationProcessingFilter( path );
      OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate( client.getClient(), oauth2ClientContext );
      oAuth2ClientAuthenticationFilter.setRestTemplate( oAuth2RestTemplate );
      UserInfoTokenServices tokenServices = new UserInfoTokenServices( client.getResource().getUserInfoUri(), client.getClient().getClientId() );
      tokenServices.setRestTemplate( oAuth2RestTemplate );
      oAuth2ClientAuthenticationFilter.setTokenServices( tokenServices );
      return oAuth2ClientAuthenticationFilter;
   }

}

class ClientResources {
   @NestedConfigurationProperty private AuthorizationCodeResourceDetails client = new AuthorizationCodeResourceDetails();
   @NestedConfigurationProperty private ResourceServerProperties resource = new ResourceServerProperties();

   public AuthorizationCodeResourceDetails getClient() {
      return client;
   }

   public ResourceServerProperties getResource() {
      return resource;
   }
}
