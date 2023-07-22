package com.heima.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2//开启Swagger2的功能
//Swagger2的配置文件
public class SwaggerConfiguration {

   //用于构建Docket对象，Docket是Swagger的主要配置对象，
   // 用于配置Swagger的基本信息、API选择等
   @Bean
   public Docket buildDocket() {
      return new Docket(DocumentationType.SWAGGER_2)
              .apiInfo(buildApiInfo())
              .select()
              // 要扫描的API(Controller)基础包
              .apis(RequestHandlerSelectors.basePackage("com.heima"))
              .paths(PathSelectors.any())
              .build();
   }

   private ApiInfo buildApiInfo() {
      Contact contact = new Contact("koutoumi","","");
      return new ApiInfoBuilder()
              .title("掌上资讯-平台管理API文档")
              .description("掌上资讯后台api")
              .contact(contact)
              .version("1.0.0").build();
   }
}