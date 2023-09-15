package com.demoweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.demoweb.interceptor.AuthInterceptor;

// servlet-context.xml 설정 파일에 대응하는 코드 기반 설정 파일 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.demoweb.controller" })
public class WebConfiguration implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MultipartResolver multipartResolver() {		
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("utf-8");
		multipartResolver.setMaxInMemorySize(2*1024*1024); // 1M 이상인 파일은 임시 파일 사용
		multipartResolver.setMaxUploadSize(10*1024*1024);; // 10M 초과 파일은 업로드 거절
		
		return multipartResolver;
	}
	
	@Bean
	public AuthInterceptor authInterceptor() {
		return new AuthInterceptor();
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor())
				.addPathPatterns("/board/**") // 인터셉터를 적용할 요청 경로
				.excludePathPatterns("/board/list", "/board/detail", "/board/download"); // 인터셉터를 적용하지 않을 요청 경로
	}
	

}








