package com.microblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.microblog.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (!registry.hasMappingForPattern("/webjars/**")) {
      registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    if (!registry.hasMappingForPattern("/css/**")) {
      registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
    }
    if (!registry.hasMappingForPattern("/js/**")) {
      registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
    }
    if (!registry.hasMappingForPattern("/node_modules/**")) {
      registry.addResourceHandler("/node_modules/**").addResourceLocations("classpath:/node_modules/");
    }
  }

  @Bean
  public InternalResourceViewResolver internalViewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/templates/");
    viewResolver.setSuffix(".html");
    viewResolver.setOrder(1);
    return viewResolver;
  }
}