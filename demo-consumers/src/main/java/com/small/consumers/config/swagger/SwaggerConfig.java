
package com.small.consumers.config.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by chen on 2019-5-22.
 * <p>
 * <p>
 * Describe: swagger 配置类
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {


  /*  @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bycdao.cloud"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui RESTful APIs")
                .description("swagger-bootstrap-ui")
                .termsOfServiceUrl("http://localhost:8999/")
                .contact("developer@mail.com")
                .version("1.0")
                .build();
    }*/

}

