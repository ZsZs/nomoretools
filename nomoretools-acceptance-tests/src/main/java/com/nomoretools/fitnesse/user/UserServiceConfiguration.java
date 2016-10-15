package com.nomoretools.fitnesse.user;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.nomoretools.fitnesse.application.ServiceConfiguration;

@ConfigurationProperties( prefix = "user-service" )
public class UserServiceConfiguration extends ServiceConfiguration{
}
