package com.example.spr28017;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Filter;
import java.util.Collections;

@SpringBootApplication
public class Spr28017Application {

    public static void main(String[] args) {
        SpringApplication.run(Spr28017Application.class, args);
    }

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        bean.setUrlPatterns(Collections.singleton("*"));
        bean.setFilter((servletRequest, servletResponse, filterChain) ->
                FileCopyUtils.copy("filterRegistrationBean", servletResponse.getWriter())
        );

        return bean;
    }

    @RestController
    @RequestMapping("/test")
    public static class TestController {

        @GetMapping
        public static String test() {
            return "test";
        }

    }

}
