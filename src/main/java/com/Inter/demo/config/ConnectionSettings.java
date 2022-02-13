package com.Inter.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The type Connection settings.
 */
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "bookspool")
public class ConnectionSettings {

    private static int DEFAULT_MAX_POOL_SIZE = 5;

    private String jdbcDriver;
    private String jdbcString;
    private String jdbcUser;
    private String jdbcPassword;
    private int jdbcMaxPoolSize = DEFAULT_MAX_POOL_SIZE;
}
