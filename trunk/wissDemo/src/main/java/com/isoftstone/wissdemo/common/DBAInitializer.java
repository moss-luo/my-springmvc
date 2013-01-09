package com.isoftstone.wissdemo.common;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class DBAInitializer {
	private HSQLServer server;
	
	@PreDestroy
	public void stop() {
		server.stop();
	}

	@PostConstruct
	public void start() {
		server = new HSQLServer();
		server.start();
	}
}
