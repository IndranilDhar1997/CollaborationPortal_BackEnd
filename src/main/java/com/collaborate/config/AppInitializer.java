package com.collaborate.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { ApplicationConfig.class, WebConfig.class,WebSocketConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
	@Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		logger.debug("Starting of the metnod customizeRegistration");
		//String path = "resources/img/";
		String path = "D:/P-II images/Events/";
        File uploadDirectory = new File(path);

        // register a MultipartConfigElement
        MultipartConfigElement multipartConfigElement =
                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
                        maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);

        registration.setMultipartConfig(multipartConfigElement);
        logger.debug("Ending of the metnod customizeRegistration");
    }
}
