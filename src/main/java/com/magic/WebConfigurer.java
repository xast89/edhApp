package com.magic;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
class WebConfigurer extends WebMvcConfigurerAdapter
{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/cards/**").addResourceLocations("file:/dev/net/cards/");
        registry.addResourceHandler("/cards/**").addResourceLocations("file:///C:/cards/");
        super.addResourceHandlers(registry);
    }

}
