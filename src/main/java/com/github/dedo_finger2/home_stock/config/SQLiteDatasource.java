package com.github.dedo_finger2.home_stock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SQLiteDatasource {
    final Environment env;

    public SQLiteDatasource(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        String driverClassName = env.getProperty("driverClassName");
        assert driverClassName != null;
        if (!driverClassName.isEmpty()) dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(env.getProperty("url"));
        return dataSource;
    }

    @Configuration
    @PropertySource("classpath:persistence.properties")
    static class SQLiteConfig {
    }
}
