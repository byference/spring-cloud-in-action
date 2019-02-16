package com.github.baifenghe.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.BodyInserters;
import springfox.documentation.swagger.web.*;
import java.util.Optional;


/**
 * swagger对外接口
 *
 * @author bfh
 * @since 1.0.0
 */
@Component
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
                .route(RequestPredicates.GET("/swagger-resources"), request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(BodyInserters.fromObject(swaggerResources.get())))
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui"), request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(BodyInserters.fromObject(Optional.ofNullable(uiConfiguration)
                                .orElse(UiConfigurationBuilder.builder().build()))))
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/security"), request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(BodyInserters.fromObject(Optional.ofNullable(securityConfiguration)
                                .orElse(SecurityConfigurationBuilder.builder().build()))));
    }

}
