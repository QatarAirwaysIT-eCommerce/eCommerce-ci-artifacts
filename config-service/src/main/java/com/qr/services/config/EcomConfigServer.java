package com.qr.services.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EcomConfigServer {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EcomConfigServer.class).run(args);
	}

}
