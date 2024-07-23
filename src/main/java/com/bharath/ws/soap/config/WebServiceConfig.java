package com.bharath.ws.soap.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bharath.ws.soap.PaymentProcessorImpl;

//import com.bt.ws.soap.HelloWs;

//import jakarta.xml.ws.Endpoint;

@Configuration

public class WebServiceConfig {

	@Bean(name = Bus.DEFAULT_BUS_ID)

	public SpringBus cxf() {

		return new SpringBus();

	}

	@Bean

	public Endpoint helloWorld() {

	    PaymentProcessorImpl implementor = new PaymentProcessorImpl();

		EndpointImpl endpoint = new EndpointImpl(cxf(), implementor);

		endpoint.publish("/paymentProcessor");

		return endpoint;

	}

}