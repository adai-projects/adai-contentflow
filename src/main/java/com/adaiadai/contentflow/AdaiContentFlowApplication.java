package com.adaiadai.contentflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author adai
 */
@SpringBootApplication
public class AdaiContentFlowApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AdaiContentFlowApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AdaiContentFlowApplication.class);
    }
}
