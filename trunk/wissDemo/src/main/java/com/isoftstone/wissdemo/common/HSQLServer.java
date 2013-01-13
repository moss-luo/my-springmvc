package com.isoftstone.wissdemo.common;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.springframework.stereotype.Component;

@Component
public class HSQLServer {
	private Server server;
	
	public void start() {
		//java -cp hsqldb.jar org.hsqldb.Server -database.0 mem:wissDemo -dbname.0 wissDemo
		server = new Server();
		HsqlProperties properties = new HsqlProperties();
		properties.setProperty("database.0", "mem:wissDemo");
		properties.setProperty("dbname.0", "wissDemo");
		server.setProperties(properties);
		server.setLogWriter(null);
		server.setErrWriter(null);
		
		server.start();
	}
	
	public void stop() {
		server.stop();
		server = null;
	}
}
