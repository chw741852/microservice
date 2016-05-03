package com.hong.server.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by caihongwei on 16/4/27 下午3:13.
 */
@Configuration
@MapperScan("com.hong.server.dao")
public class MybatisConfig {
    /**
     * 配置druid数据库连接池
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "druid.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
