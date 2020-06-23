package com.example.demo;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> servletContainerCustomizer() {
		return (factory) -> {
			((TomcatServletWebServerFactory) factory)
					.addConnectorCustomizers((connector) -> {
						((AbstractHttp11Protocol<?>) connector.getProtocolHandler())
								.setUseServerCipherSuitesOrder(true);
					});
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
