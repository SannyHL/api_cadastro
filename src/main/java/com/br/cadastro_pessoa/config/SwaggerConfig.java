package com.br.cadastro_pessoa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
public class SwaggerConfig {
    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.br.cadastro_pessoas.controllers"))
        .build()
        .apiInfo(metaData());
    }

    private ApiInfo metaData(){
        return new ApiInfoBuilder()
        .title("API REST Pessoas")
        .description("API REST para cadastro de pessoas no banco de dados")
        .version("1.0.0")
        .contact(new Contact("Sanny Helen Lima", "https://github.com/SannyHL/api_cadastro_pessoas", "sannyhelenlima@gmail.com"))
        .build();
    }
}
