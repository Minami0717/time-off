package com.minami.timeoff;

import com.minami.timeoff.common.config.properties.AppProperties;
import com.minami.timeoff.common.config.properties.CorsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({AppProperties.class, CorsProperties.class })
public class TimeOffApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeOffApplication.class, args);
    }

}
