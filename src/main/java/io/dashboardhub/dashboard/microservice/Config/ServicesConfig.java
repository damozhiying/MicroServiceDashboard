package io.dashboardhub.dashboard.microservice.Config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ConfigurationProperties("app")
public class ServicesConfig {

    private List<String> services = new ArrayList<String>();

    public List<String> getServices() {
        return this.services;
    }
}
