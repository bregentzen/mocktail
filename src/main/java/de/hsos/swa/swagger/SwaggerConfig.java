package de.hsos.swa.swagger;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
        tags = {
                @Tag(name = "drinks", description = "Operations on Drinks foo-database")
        },
        info = @Info(
                title = "API with Quarkus for CRUD operations for mock- and cocktails",
                version = "1.0",
                contact = @Contact(
                        name = "Semir Kuc",
                        url = "https://fakeWebSite.de",
                        email = "semirk@fooMail.com"
                ),
                license = @License(
                        name = "FAKE",
                        url = "https://fakeWebSite.com/licenses/FAKE"
                )
        )
)
public class SwaggerConfig extends Application {}
