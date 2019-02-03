package com.github.baifenghe.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bfh
 * @since 1.0.0
 */
@Primary
@Component
public class SwaggerProvider implements SwaggerResourcesProvider {

    @Value("${spring.application.name}")
    public String applicationName;

    private final RouteLocator routeLocator;

    public SwaggerProvider(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    @Override
    public List<SwaggerResource> get() {

        List<SwaggerResource> resources = new ArrayList<>();
        routeLocator.getRoutes().subscribe(route -> {
            String routeUri = route.getUri().getHost();
            if (!applicationName.equalsIgnoreCase(routeUri)) {
                resources.add(swaggerResource(routeUri, String.format("/%s/v2/api-docs", routeUri)));
            }
        });
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location) {

        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setSwaggerVersion("2.0");
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        return swaggerResource;
    }


}
