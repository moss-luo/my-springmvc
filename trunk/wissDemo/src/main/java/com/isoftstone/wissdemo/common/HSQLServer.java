package com.isoftstone.wissdemo.common;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;

@Component
public class HSQLServer {
	private Server server;
	
	public void start() {
		server = new Server();
		HsqlProperties properties = new HsqlProperties();
		properties.setProperty("database.0", "mem:wissDemo");
		properties.setProperty("dbname.0", "wissDemo");
		server.setProperties(properties);
		server.setLogWriter(null);
		server.setErrWriter(null);
		
		server.start();
		
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL).addScript("wissDemo.sql").build();
		db.shutdown();
	}
	
	public void stop() {
		server.stop();
		server = null;
	}
}
