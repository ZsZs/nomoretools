package com.nomoretools.fitnesse.document;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.nomoretools.fitnesse.application.ServiceConfiguration;

@ConfigurationProperties( prefix = "document-service" )
public class DocumentServiceConfiguration extends ServiceConfiguration {

}
