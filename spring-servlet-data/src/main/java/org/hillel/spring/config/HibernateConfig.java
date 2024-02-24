package org.hillel.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@PropertySource("classpath:hibernate.properties")
@EnableTransactionManagement
public class HibernateConfig {
    @Value("${db.driver}")
    private String driverName;
    @Value("${db.url}")
    private String dbUrl;
    @Value("${db.user}")
    private String dbUser;
    @Value("${db.password}")
    private String dbPassword;
    @Value("${db.show-sql}")
    private String showSlq;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("org.hillel.spring.model.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());


        return sessionFactory;
    }
    @Bean
    public Session session(SessionFactory sessionFactory) {
        return sessionFactory.openSession();
    }
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);

        return dataSource;
    }


    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", showSlq);
        return properties;
    }
}
