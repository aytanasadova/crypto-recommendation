package xm.cryptorecommendation.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi testApi() {
        return GroupedOpenApi.builder()
                .group("test")
                .pathsToMatch("/test")
                .build();
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("crypto-recommendation-methods")
                .pathsToMatch("/**")
                .build();
    }


    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Crypto recommendation API")
                        .description("Crypto investment recommendation application")
                        .version("v1")
                        .license(new License().name("XM-Big, Established and Experienced").url("https://www.xm.com/")));
//                .externalDocs(new ExternalDocumentation()
//                        .description("XM")
//                        .url("https://www.xm.com/"));
    }
//    @Bean
//    public GroupedOpenApi adminApi() {
//        return GroupedOpenApi.builder()
//                .group("springshop-admin")
//                .pathsToMatch("/admin/**")
//                .addMethodFilter(method -> method.isAnnotationPresent(Admin.class))
//                .build();
//    }

}
