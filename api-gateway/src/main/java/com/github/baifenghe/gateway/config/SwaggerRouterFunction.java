package com.github.baifenghe.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import springfox.documentation.swagger.web.*;

import java.util.Optional;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

/**
 * swagger对外接口
 *
 * @author bfh
 * @since 1.0.0
 */
//@Component
public class SwaggerRouterFunction {


    @Autowired(required = false)
    private SecurityConfiguration securityConfiguration;

    @Autowired(required = false)
    private UiConfiguration uiConfiguration;

    @Autowired
    private SwaggerResourcesProvider swaggerResources;

    @Bean
    public RouterFunction<?> routerFunction() {

        return RouterFunctions
                .route(GET("/swagger-resources"), request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(BodyInserters.fromObject(swaggerResources.get())))
                .andRoute(GET("/swagger-resources/configuration/ui"), request -> ServerResponse.status(HttpStatus.OK)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .body(BodyInserters.fromObject(
                                        Optional.ofNullable(uiConfiguration)
                                                .orElse(UiConfigurationBuilder.builder().build()))))
                .andRoute(GET("/swagger-resources/configuration/security"), request -> ServerResponse.status(HttpStatus.OK)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .body(BodyInserters.fromObject(
                                        Optional.ofNullable(securityConfiguration)
                                                .orElse(SecurityConfigurationBuilder.builder().build()))));
    }

}
