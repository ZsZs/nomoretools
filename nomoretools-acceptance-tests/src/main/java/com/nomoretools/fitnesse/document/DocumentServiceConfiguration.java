package com.nomoretools.fitnesse.document;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.nomoretools.fitnesse.application.ServiceConfiguration;

@Component
@ConfigurationProperties( prefix = "document-service" )
public class DocumentServiceConfiguration extends ServiceConfiguration {

}
