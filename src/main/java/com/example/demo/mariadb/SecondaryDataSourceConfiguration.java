package com.example.demo.mariadb;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class SecondaryDataSourceConfiguration {
    @Bean
    @ConfigurationProperties("database2.datasource")
    public DataSourceProperties mariadbDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource secondaryDataSource() {
        return mariadbDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }
}
