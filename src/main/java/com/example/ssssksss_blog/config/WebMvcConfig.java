package com.example.ssssksss_blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedMethods("GET","POST","*") // 허용할 http 메소드
//                .maxAge(3000) //pre-flight 리퀘스트 캐싱
                .allowedOrigins("https://blog.ssssksss.xyz","http://localhost:3000","http://localhost:3002"
                ,"http://blog.ssssksss.xyz");
    }
}