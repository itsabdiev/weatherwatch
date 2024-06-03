package kg.aiu.weatherwatch.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;



@OpenAPIDefinition (
        info = @Info(
                contact = @Contact(
                        name = "Atai Abdiev",
                        email = "abdiev0225@gmail.com",
                        url = "https://github.com/itsabdiev"
                ),
                description = "Open Api documentation for my diploma fifth task",
                title = "WeatherWatch Documentation",
                version = "1.0",
                license = @License (
                        name = "Gigachad Licence"
                )
        ),
        servers = {
                @Server (
                        description = "Local ENV",
                        url = "http://localhost:8820"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }

)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfiguration {
}
