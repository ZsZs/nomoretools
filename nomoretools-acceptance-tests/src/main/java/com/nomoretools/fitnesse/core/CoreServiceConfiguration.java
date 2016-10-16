package com.nomoretools.fitnesse.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.nomoretools.fitnesse.application.ServiceConfiguration;

@Component
@ConfigurationProperties( prefix = "core-service" )
public class CoreServiceConfiguration extends ServiceConfiguration {

}
