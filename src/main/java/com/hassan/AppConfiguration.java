package com.hassan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Value( "${DB_URL}" )
    private String db_url;


}
