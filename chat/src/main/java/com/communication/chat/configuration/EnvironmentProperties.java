package com.communication.chat.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/environment.properties")
@PropertySource(value = "file:///${CHAT_ENV}/environment.properties", ignoreResourceNotFound = true)
public class EnvironmentProperties {
    
	@Autowired
	private Environment environment;

	public String mongoconnectionstring() {
		return environment.getProperty("database.mongo.connection");
	}

	public String getmongodbname() {
		return environment.getProperty("database.mongo.dbname");
	}
}
