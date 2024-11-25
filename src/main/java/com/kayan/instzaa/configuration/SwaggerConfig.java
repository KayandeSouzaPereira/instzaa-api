package com.kayan.instzaa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

        public static final String SCHEME_NAME = "BearerScheme";
        public static final String SCHEME = "Bearer";

        @Bean
        public OpenAPI customOpenAPI() {
            var openApi = new OpenAPI().info(this.apiInfo());
            this.addSecurity(openApi);
            return openApi;
        }

        private Info apiInfo() {
            var contact = new Contact();
            contact.setEmail("kayandesouzapereira@hotmail.com");
            contact.setName("Kayan de Souza");
            contact.setUrl("https://kayanpereira.tech/");
            return new Info()
                    .title("Instzaa API")
                    .description("Api de Delivery")
                    .termsOfService("")
                    .contact(contact)
                    // TODO: Version should be dynamically
                    .version("0.1.0");
        }

        private void addSecurity(OpenAPI openApi) {
            var components = this.createComponents();
            var securityItem = new SecurityRequirement().addList(SCHEME_NAME);
            openApi.components(components).addSecurityItem(securityItem);
        }

        private Components createComponents() {
            var components = new Components();
            components.addSecuritySchemes(SCHEME_NAME, this.createSecurityScheme());
            return components;
        }

        private SecurityScheme createSecurityScheme() {
            return new SecurityScheme().name(SCHEME_NAME).type(SecurityScheme.Type.HTTP).scheme(SCHEME);
        }
}
