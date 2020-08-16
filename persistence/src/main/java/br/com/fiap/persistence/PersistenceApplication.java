package br.com.fiap.persistence;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@SpringBootApplication()
@EnableJpaRepositories("br.com.fiap")
@ComponentScan("br.com.fiap")
@EnableCreateCacheAnnotation
@EnableSwagger2
public class PersistenceApplication  {

    public static void main(String[] args) {
        SpringApplication.run(PersistenceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .paths(Predicates.not(PathSelectors.regex("/actuator.*")))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfo(
                        "Model Cache Persistence API",
                        "Mysql Data using cache Redis.",
                        "1.0",
                        "Terms of service",
                        new Contact("GaLuAl", "www.fiap.com.br", ""),
                        "License of API", "API license URL", Collections.emptyList())
                );
    }

}
