package com.nomoretools.fitnesse.user;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.nomoretools.fitnesse.application.ServiceConfiguration;

@Component
@ConfigurationProperties( prefix = "user-service" )
public class UserServiceConfiguration extends ServiceConfiguration {
}
