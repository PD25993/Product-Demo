//package com.springboot.productdemo.web.configs;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Import;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//
//
//@ComponentScan(basePackages="com.springboot.productdemo.web")
//@EnableSwagger2WebFlux
//@Import(springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class)
//public class SpringFoxConfig {                                    
//    @Bean
//    public Docket api() { 
//        return new Docket(DocumentationType.SWAGGER_2)  
//          .select()        //returns an instance of ApiSelectorBuilder, which provides a way to control the endpoints exposed by Swagger.
//          //Predicates for selection of RequestHandlers can be configured with the help of RequestHandlerSelectors and PathSelectors. 
//          //Using any() for both will make documentation for your entire API available through Swagger.
//          .apis(RequestHandlerSelectors.any())              
//          .paths(PathSelectors.any())                          
//          .build().pathMapping("/") ;                                           
//    }
//}
//
