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

	/*@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
		driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/hairdressing");
		driverManagerDataSource.setUsername("hairdressingmaster");
		driverManagerDataSource.setPassword("riomam150968");
		return driverManagerDataSource;
	}*/

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
		driverManagerDataSource.setUrl(
				"jdbc:postgres://ruixtascnjatoe:6280b38ebd10415ca5023949d19ce1a4159a5a29128c240fa8bc653195afcb55@ec2-54-83-59-144.compute-1.amazonaws.com:5432/d1fe7d9ifvelh4");
		driverManagerDataSource.setUsername("ruixtascnjatoe");
		driverManagerDataSource.setPassword("6280b38ebd10415ca5023949d19ce1a4159a5a29128c240fa8bc653195afcb55");
		return driverManagerDataSource;
	}
}
