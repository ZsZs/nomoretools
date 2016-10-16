package com.nomoretools.fitnesse.frontend;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.nomoretools.fitnesse.application.ServiceConfiguration;

@Component
@ConfigurationProperties( prefix = "front-end-service" )
public class FrontEndServiceConfiguration extends ServiceConfiguration {

}
