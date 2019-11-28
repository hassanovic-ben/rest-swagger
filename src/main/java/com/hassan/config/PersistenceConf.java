package com.hassan.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class PersistenceConf {

    @Bean
    public DataSource getDataSource(){

        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:mysql://localhost:3306/shoe_shop?serverTimezone=UTC");
        builder.username("root");
        builder.password("root");
        return builder.build();

    }
}
