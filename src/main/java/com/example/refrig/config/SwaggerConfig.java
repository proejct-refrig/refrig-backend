package com.example.refrig.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        String jwt = "JWT";

        // API 요청 헤더에 인증정보 포함
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwt);

        // SecuritySchemes 등록
        Components components = new Components().addSecuritySchemes(jwt, new SecurityScheme()
                .name(jwt)
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT"));

        return new OpenAPI()
                .components(new Components())
                .info(apiInfo())
                .addSecurityItem(securityRequirement)
                .components(components);
    }
    private Info apiInfo() {
        return new Info()
                .title("우리집에 가면")
                .description("우리집에 가면")
                .version("1.0.0");
    }

//    @Bean
//    public GroupedOpenApi groupItem() {
//        return GroupedOpenApi.builder()
//                .group("item")
//                .displayName("재고물품")
////                .pathsToMatch("/api/")
//                // todo: pathsToMatch 보강
//                .build();
//    }

    @Bean
    public GroupedOpenApi groupGroup() {
        return GroupedOpenApi.builder()
                .group("group")
                .displayName("그룹")
                .pathsToMatch("/api/groups/**")
                .build();
    }

//    @Bean
//    public GroupedOpenApi groupMember() {
//        return GroupedOpenApi.builder()
//                .group("member")
//                .displayName("멤버")
////                .pathsToMatch()
//                .build();
//    }

}