package com.nomoretools.fitnesse.frontend;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.nomoretools.fitnesse.application.ServiceConfiguration;

@ConfigurationProperties( prefix = "front-end-service" )
public class FrontEndServiceConfiguration extends ServiceConfiguration {

}
