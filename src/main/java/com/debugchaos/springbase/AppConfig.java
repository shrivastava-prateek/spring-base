package com.debugchaos.springbase;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.debugchaos.springbase.entity")
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean(name = "postgres")
	public DataSource postgresDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.postgresql.Driver");
		dataSourceBuilder.url("jdbc:postgresql://localhost:5432/postgres");
		dataSourceBuilder.username("postgres");
		dataSourceBuilder.password("postgres");
		return dataSourceBuilder.build();
	}

	@Bean(name = "postgres2")
	public DataSource postgresDataSource2() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.postgresql.Driver");
		dataSourceBuilder.url("jdbc:postgresql://localhost:5433/postgres");
		dataSourceBuilder.username("postgres");
		dataSourceBuilder.password("somePassword");
		return dataSourceBuilder.build();
	}

	@Bean(name= "postgresEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(postgresDataSource());
		em.setPackagesToScan("com.debugchaos.springbase.entity");
		em.setPersistenceUnitName("postgresEntityManagerFactory");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(additionalProperties());
		// rest of entity manager configuration
		return em;
	}

	@Bean(name = "postgresEntityManagerFactory2")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory2() throws NamingException {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(postgresDataSource2());
		em.setPackagesToScan("com.debugchaos.springbase.entity");
		em.setPersistenceUnitName("postgresEntityManagerFactory2");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(additionalProperties());
		// rest of entity manager configuration
		return em;
	}

	@Bean("postgresJpaTransaction")
	public PlatformTransactionManager transactionManager() throws NamingException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean("postgresJpaTransaction2")
	public PlatformTransactionManager transactionManager2() throws NamingException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory2().getObject());
		return transactionManager;
	}

	Properties additionalProperties(){
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.generate_statistics", env.getProperty("hibernate.generate_statistics"));
		properties.setProperty("hibernate.use_sql_comments", env.getProperty("hibernate.use_sql_comments"));
		properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

		return properties;
	}



	
}
