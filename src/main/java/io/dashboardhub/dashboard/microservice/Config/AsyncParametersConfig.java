package io.dashboardhub.dashboard.microservice.Config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ConfigurationProperties("app.async")
public class AsyncParametersConfig {

    private String name;
    private Integer corePoolSize;
    private Integer maxPoolSize;
    private Integer queueCapacity;
}
