package com.swontech.s02.config;

import com.swontech.s02.props.DBProperty;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfiguration {
    private final DBProperty dbProperty;

    @Bean(name = "primaryDataSource")
    public HikariDataSource primaryDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(dbProperty.getPrimaryUrl());
        hikariDataSource.setDriverClassName(dbProperty.getPrimaryDriver());
        hikariDataSource.setUsername(dbProperty.getPrimaryUserName());
        hikariDataSource.setPassword(dbProperty.getPrimaryPassword());

        return hikariDataSource;
    }
}
