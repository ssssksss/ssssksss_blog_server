package com.example.ssssksss_blog;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@SpringBootApplication
//public class SsssksssBlogApplication extends SpringBootServletInitializer {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SsssksssBlogApplication.class, args);
//	}
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return super.configure(builder);
//	}
//}

// datasource에러가 자꾸 발생해서 뭔가 수정이  필요할듯 싶다...
@EnableJpaAuditing
@SpringBootApplication
public class SsssksssBlogApplication extends SpringBootServletInitializer {
//	public static final String APPLICATION_LOCATIONS = "spring.config.location="
////			+ "classpath:application.yml,"
////			+ "/usr/local/tomcat8/application.yml";
//			+ "C:/test/application.yml";

	public static void main(String[] args) {
		new SpringApplicationBuilder(SsssksssBlogApplication.class)
//				.properties(APPLICATION_LOCATIONS)
				.run(args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return super.configure(builder);
//	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(SsssksssBlogApplication.class);
//	}

}


