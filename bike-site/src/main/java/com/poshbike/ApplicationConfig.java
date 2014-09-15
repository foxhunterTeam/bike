package com.poshbike;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring JavaConfig configuration class to setup a Spring container and
 * infrastructure components like a {@link DataSource}, a
 * {@link EntityManagerFactory} and a {@link PlatformTransactionManager}.
 * 
 */
@Configuration
@ComponentScan(includeFilters = { @Filter(Service.class) }, useDefaultFilters = false)
@EnableAsync
@EnableAspectJAutoProxy
@EnableJpaRepositories
@EnableTransactionManagement

@ImportResource({ 
	"classpath:security.xml"

})
class ApplicationConfig {

	/**
	 * Bootstraps an in-memory HSQL database.
	 * 
	 * @return
	 * @see http 
	 *      ://static.springsource.org/spring/docs/3.1.x/spring-framework-reference
	 *      /html/jdbc.html#jdbc-embedded-database -support
	 */
	@Bean
	public DataSource dataSource() {
		 EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		 return builder.setType(EmbeddedDatabaseType.HSQL).build();

		// Tomcat dbpool
		/*Context ctx;
		try {
			ctx = new InitialContext();
			return (DataSource) ctx.lookup("java:comp/env/jdbc/dbpool");
		} catch (NamingException e) {
			e.printStackTrace();
		}*/

	}

	/**
	 * Sets up a {@link LocalContainerEntityManagerFactoryBean} to use
	 * Hibernate. Activates picking up entities from the project's base package.
	 * 
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setDatabase(Database.HSQL);
		//vendorAdapter.setDatabase(Database.MYSQL);
		
		// vendorAdapter.setGenerateDdl(true);
		// vendorAdapter.setShowSql(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(getClass().getPackage().getName());
		factory.setDataSource(dataSource());

		Properties jpaProperties = new Properties() {
			{

				// setProperty("hibernate.query.substitutions",
				// "true 'Y', false 'N'");
				// setProperty("hibernate.max_fetch_depth", "4");

				setProperty("hibernate.show_sql", "true");

				setProperty("hibernate.cache.use_second_level_cache", "true");
				setProperty("hibernate.cache.use_query_cache", "true");
				setProperty("hibernate.cache.region.factory_class",
						"org.hibernate.cache.ehcache.EhCacheRegionFactory");
			}
		};
		factory.setJpaProperties(jpaProperties);

		return factory;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}

}
