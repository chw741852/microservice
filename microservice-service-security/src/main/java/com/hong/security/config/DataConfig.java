package com.hong.security.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by caihongwei on 16/6/20 下午5:06.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.hong.security.repository")
@EnableTransactionManagement
public class DataConfig {

    @Bean
    @ConfigurationProperties(prefix="druid.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.hong.security.domain");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(getJpaProperties());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory());
        return transactionManager;
    }

    private Properties getJpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.ejb.naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringNamingStrategy");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.jdbc.fetch_size", "100");
        properties.put("hibernate.jdbc.batch_size", "20");
        return properties;
    }
}
