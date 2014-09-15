package com.poshbike;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * Servlet 3.0 {@link WebApplicationInitializer} using Spring 3.2 convenient
 * base class {@link AbstractAnnotationConfigDispatcherServletInitializer}. It
 * essentially sets up a root application context from {@link ApplicationConfig}
 * , and a dispatcher servlet application context from {@link WebConfiguration}
 * for general Spring MVC customizations.
 * 
 */
public class RestWebApplicationInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.support.
	 * AbstractAnnotationConfigDispatcherServletInitializer
	 * #getRootConfigClasses()
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { ApplicationConfig.class };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.servlet.support.
	 * AbstractAnnotationConfigDispatcherServletInitializer
	 * #getServletConfigClasses()
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfiguration.class };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.support.AbstractDispatcherServletInitializer
	 * #getServletMappings()
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.support.AbstractDispatcherServletInitializer
	 * #getServletFilters()
	 */
	@Override
	protected javax.servlet.Filter[] getServletFilters() {
		CharacterEncodingFilter encodeFilter = new CharacterEncodingFilter();
		encodeFilter.setEncoding("UTF-8");
		encodeFilter.setForceEncoding(true);
		return new javax.servlet.Filter[] { encodeFilter,
				new OpenEntityManagerInViewFilter() };
	}

	/**
	 * Web layer configuration enabling Spring MVC, Spring Hateoas hypermedia
	 * support.
	 * 
	 * @author Oliver Gierke
	 */
	@Configuration
	@ComponentScan(excludeFilters = @Filter({ Service.class,
			Configuration.class }))
	public static class WebConfiguration extends WebMvcConfigurationSupport {

		@Bean
		public DomainClassConverter<?> domainClassConverter() {
			return new DomainClassConverter<FormattingConversionService>(
					mvcConversionService());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.web.servlet.config.annotation.
		 * WebMvcConfigurationSupport
		 * #configureContentNegotiation(org.springframework
		 * .web.servlet.config.annotation.ContentNegotiationConfigurer)
		 */
		@Override
		public void configureContentNegotiation(
				ContentNegotiationConfigurer configurer) {
			configurer.defaultContentType(MediaType.APPLICATION_JSON);
		}

		@Override
		public void configureMessageConverters(
				List<HttpMessageConverter<?>> converters) {
			MappingJackson2HttpMessageConverter jackson2converter = new MappingJackson2HttpMessageConverter();
			jackson2converter.getObjectMapper().setDateFormat(
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

			jackson2converter.getObjectMapper().registerModule(
					new Hibernate4Module());

			converters.add(jackson2converter);
		}

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/js/**").addResourceLocations("/js/");

		}

		@Bean
		public ViewResolver addViewResolver() {
			InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
			viewResolver.setPrefix("/jsp/");
			viewResolver.setSuffix(".jsp");
			return viewResolver;
		}

	}

}
