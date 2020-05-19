package com.springboot.productdemo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot.productdemo.web")
//@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ProductDemoApplication{

	//private  Logger logger = LoggerFactory.getLogger(this.getClass());

	@Bean
	public RestTemplate getRestTemplateInstance()
	{
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(ProductDemoApplication.class, args);
	}

}
