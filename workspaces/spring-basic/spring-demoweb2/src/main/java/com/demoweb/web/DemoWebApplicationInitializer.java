package com.demoweb.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.demoweb.config.RootConfiguration;
import com.demoweb.config.WebConfiguration;

// web.xml 역할을 수행하는 코드 기반 설정 파일
public class DemoWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] { RootConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
//		FilterRegistration characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
//		characterEncodingFilter.setInitParameter("encoding", "UTF-8");
//		characterEncodingFilter.setInitParameter("forceEncoding", "true");
//		characterEncodingFilter.addMappingForUrlPatterns(null, true, "/*");
		
		super.onStartup(servletContext);
	}

}
