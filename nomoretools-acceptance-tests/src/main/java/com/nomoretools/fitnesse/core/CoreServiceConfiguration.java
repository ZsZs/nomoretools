package com.nomoretools.fitnesse.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.nomoretools.fitnesse.application.ServiceConfiguration;

@ConfigurationProperties( prefix = "core-service" )
public class CoreServiceConfiguration extends ServiceConfiguration {

}
