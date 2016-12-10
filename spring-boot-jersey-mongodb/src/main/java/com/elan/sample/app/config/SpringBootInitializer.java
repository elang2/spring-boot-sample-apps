package com.elan.sample.app.config;

import org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
@ComponentScan(basePackages={"com.elan.sample.app"})
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class, EmbeddedMongoAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
@EnableMongoRepositories(basePackages="com.elan.sample.app.store.mongo.repository")
public class SpringBootInitializer extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootInitializer.class);
	}
	
    public static void main(String[] args) {
        new SpringBootInitializer()
            .configure(new SpringApplicationBuilder(SpringBootInitializer.class)).run(args);
        
        
    }
}