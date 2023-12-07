package com.example.demo.oracle;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PrimaryDataSourceConfiguration {
    @Bean
    @ConfigurationProperties("database1.datasource")
    public DataSourceProperties oracleDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource primaryDataSource() {
        return oracleDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }
}
