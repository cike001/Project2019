package net.gwy.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author guoweiyang
 * @date 2019-04-27
 */
@Configuration
public class Config {


    @Bean
    public CorsFilter corsFilter(){
        System.out.println("*****跨域过滤器****");
        UrlBasedCorsConfigurationSource url = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(null);
        corsConfiguration.setAllowedMethods(null);
        corsConfiguration.setAllowedOrigins(null);
        url.registerCorsConfiguration("/*",corsConfiguration);
        return new CorsFilter(url);
    }
}
