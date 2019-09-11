package com.imuka.imuka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket productApi() {
        
        
        return new Docket(DocumentationType.SWAGGER_2).select()

                .apis(RequestHandlerSelectors
                .basePackage("com.imuka.imuka.rest.controller"))
                .paths(PathSelectors.regex("/rs.*"))
                .build()
                .apiInfo(apiEndPointsInfo());
             
    }
    
   
   protected void addResourceHandlers(ResourceHandlerRegistry registry) {
     registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    private ApiInfo apiEndPointsInfo() {

        return new ApiInfoBuilder().title("Imuka Rest Api")

            .description("Imuka RestEnd Points")
            .contact(new Contact("Tendo . K. Martyn", "+256-751-319-201", "tmkmart@gmail.com"))
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build();

    }
    
    
}
