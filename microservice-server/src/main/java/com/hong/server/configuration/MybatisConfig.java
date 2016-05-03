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
     * 用于扫描mybatis配置文件
     */
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setTypeAliasesPackage("com.hong.server.domain");
//        factory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath*:com/hong/**/dao/*Mapper.xml"));
//        return factory.getObject();
//    }

    /**
     * 配置druid数据库连接池
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "druid.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
