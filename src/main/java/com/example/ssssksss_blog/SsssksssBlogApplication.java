package com.example.ssssksss_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@SpringBootApplication
//public class SsssksssBlogApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SsssksssBlogApplication.class, args);
//	}
//
//}

//
@SpringBootApplication
public class SsssksssBlogApplication extends SpringBootServletInitializer {
	public static final String APPLICATION_LOCATIONS = "spring.config.location="
//			+ "classpath:application.yml,"
			+ "/usr/local/tomcat8/application.yml";
//			+ "C:/test/application.yml";
	public static void main(String[] args) {
		new SpringApplicationBuilder(SsssksssBlogApplication.class)
				.properties(APPLICATION_LOCATIONS)
				.run(args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return super.configure(builder);
//	}
}


