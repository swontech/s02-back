package com.swontech.s02.config;

import com.swontech.s02.props.DataSourceProperty;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfiguration {
    private final DataSourceProperty dbProperty;

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
