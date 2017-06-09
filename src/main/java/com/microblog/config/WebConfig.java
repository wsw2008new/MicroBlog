package com.microblog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("../webapp/index.html");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if(!registry.hasMappingForPattern("/static/**")) {
      registry.addResourceHandler("/static/**").addResourceLocations("/webjars/");
    }
    if(!registry.hasMappingForPattern("/node_modules/**")) {
      registry.addResourceHandler("/node_modules/**").addResourceLocations("/node_modules/");
    }
  }
}