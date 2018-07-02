package com.mob2m.hairdressing.model.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

//@Configuration
//@EnableWebMvc
public class MvcConfig { //extends WebMvcConfigurerAdapter {


	//@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		/*registry.addViewController("/home").setViewName("home");*/
		//registry.addViewController("/").setViewName("agenda");
		/*registry.addViewController("/agenda").setViewName("agenda");
		registry.addViewController("/login").setViewName("login");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);*/
	}

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
		driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/hairdressing");
		driverManagerDataSource.setUsername("hairdressingmaster");
		driverManagerDataSource.setPassword("riomam150968");
		return driverManagerDataSource;
	}
}
