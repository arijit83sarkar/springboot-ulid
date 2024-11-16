package com.raven.springboot_ulid.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "${app.name}",
                description = "${app.description}",
                version = "${app.version}",
                license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
                ),
                termsOfService = "http://swagger.io/terms/"
        )
)
public class SwaggerOpenAPIConfiguration {
}

// swagger URL- http://localhost:8090/swagger-ui/index.html
