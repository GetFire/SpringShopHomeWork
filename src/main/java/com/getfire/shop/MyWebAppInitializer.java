package com.getfire.shop;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebAppInitializer implements WebApplicationInitializer {
//public class MyWebAppInitializer  {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("/WEB-INF/appconfig-root.xml");

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("appServlet",
                new DispatcherServlet(appContext));
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(null, 5000000, 500000, 0);
        dispatcher.setMultipartConfig(multipartConfigElement);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
