package com.config;

import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com")
@PropertySource(value = { "classpath:application.properties" })
@EnableScheduling
@EnableWebMvc
public class Configurations extends WebMvcConfigurerAdapter {

	@Bean
	public static PropertyPlaceholderConfigurer placeHolderConfigurer() {
		PropertyPlaceholderConfigurer placeHolderConfigurer = new PropertyPlaceholderConfigurer();
		ClassPathResource[] cpResources = new ClassPathResource[] { new ClassPathResource(
				"application.properties") };
		placeHolderConfigurer.setLocations(cpResources);
		placeHolderConfigurer.setIgnoreUnresolvablePlaceholders(true);

		return placeHolderConfigurer;
	}

	@Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


	/*@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();

		// Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSizePerFile(5242880);// 5MB
		return resolver;
	}
*/
	/*@Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(5242880); // 5 MB
        return multipartResolver;
    }*/
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	public static Properties APPLICATION_PROPERTIES;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
		registry.addResourceHandler("/resources/static/js/**")
				.addResourceLocations("/resources/static/js/");
		registry.addResourceHandler("/resources/static/css/**")
				.addResourceLocations("/resources/static/css/");
		registry.addResourceHandler("/resources/static/**")
				.addResourceLocations("/resources/static/");
	}
	// @Override
	// public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
	// System.out.println("configureTasks");
	// taskRegistrar.setScheduler(taskExecutor());
	// }
	//
	// @Bean(destroyMethod="shutdown")
	// public Executor taskExecutor() {
	// return Executors.newScheduledThreadPool(1);
	// }
}