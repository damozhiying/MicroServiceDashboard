package io.dashboardhub.dashboard.microservice.Config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@ConfigurationProperties("app")
public class ServicesParametersConfig {

    private List<Service> services = new ArrayList<Service>();

    public List<Service> getServices() {
        return this.services;
    }

    @Data
    public static class Service {

        private String id;
        private String host;
    }
}
