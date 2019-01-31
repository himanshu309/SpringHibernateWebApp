package com.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.config.Configurations;
import com.config.HibernateConfig;


public class AppInitializer /*extends AbstractAnnotationConfigDispatcherServletInitializer*/ implements WebApplicationInitializer  {

	public void onStartup(ServletContext container) throws ServletException {
		System.out.println("onStartup");
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(Configurations.class);
		ctx.setServletContext(container);
		ctx.register(HibernateConfig.class);
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
	
	/*@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { Configurations.class,HibernateConfig.class };
    }
   
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
   
    @Override
    protected String[] getServletMappings() {
    	System.out.println("servlet mapping ");
        return new String[] { "/" };
    }*/
     
    /*@Override
    protected Filter[] getServletFilters() {
        Filter [] singleton = { new CORSFilter()};
        return singleton;
    }
*/
}
