package com.bmd.report;

import com.sun.faces.config.ConfigureListener;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.faces.webapp.FacesServlet;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ReportApplication{

    public static void main(String[] args) {
        SpringApplication.run(ReportApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean jsfServletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registrationBean.setServlet(new FacesServlet());
        registrationBean.addUrlMappings("*.jsf");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public ServletContextInitializer servletContextCustomizer() {
        return servletContext -> {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", "true");
            servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
            servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "client");
            servletContext.setInitParameter("com.sun.faces.enableRestoreView11Compatibility", "true");
            servletContext.setInitParameter("javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE", "true");
            servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
            servletContext.setInitParameter("primefaces.THEME", "fairy");
            servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
            servletContext.setInitParameter("javax.faces.FACELETS_LIBRARIES", "/WEB-INF/primefaces-fairy.taglib.xml");
            servletContext.setInitParameter("primefaces.FONT_AWESOME", "true");
        };
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(new ConfigureListener());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public static CustomScopeConfigurer viewScope() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        Map<String, Object> param = new HashMap<>();
        param.put("view", new ViewScope());
        configurer.setScopes(param);
        return configurer;
    }

}
