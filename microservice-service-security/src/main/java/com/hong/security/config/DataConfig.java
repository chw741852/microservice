package com.hong.security.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by caihongwei on 16/6/20 下午5:06.
 */
@Configuration
@MapperScan(basePackages="com.hong.security.mapper")
//@EnableTransactionManagement
public class DataConfig {

    @Bean
    @ConfigurationProperties(prefix="druid.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
