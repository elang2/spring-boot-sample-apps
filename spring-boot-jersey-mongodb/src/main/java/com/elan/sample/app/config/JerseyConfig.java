package com.elan.sample.app.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.scanning.PackageNamesScanner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    
	public JerseyConfig() {
		PackageNamesScanner resourceFinder = new PackageNamesScanner(new String[] { "com.elan.sample.app"}, true);
		registerFinder(resourceFinder);
		register(JacksonFeature.class);
	}
}
