package cn.mydrn.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfigurerAdapter implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getFrontFilter());
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Bean
    public FrontFilter getFrontFilter() {
        return new FrontFilter();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

}
