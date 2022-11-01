package com.raz.linksApi.shared;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableSwagger2
public class SpringFoxConfig {
  @Bean
  public Docket api(){
      return new Docket(DocumentationType.SWAGGER_2)
      .select()
      .apis()
      .paths()
      .build();
  }
}