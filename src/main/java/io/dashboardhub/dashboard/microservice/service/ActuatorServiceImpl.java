package io.dashboardhub.dashboard.microservice.service;

import io.dashboardhub.dashboard.microservice.Config.ServicesParametersConfig;
import io.dashboardhub.dashboard.microservice.entity.Actuator;
import io.dashboardhub.dashboard.microservice.repository.ActuatorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@org.springframework.stereotype.Service
@EnableAsync
public class ActuatorServiceImpl implements ActuatorService {

    @Autowired
    private ServicesParametersConfig servicesParametersConfig;

    @Autowired
    private ActuatorRepository actuatorRespository;

    private static final Logger log = LoggerFactory.getLogger(ActuatorService.class);

    public List<Actuator> getServices() {
        List<Future<Actuator>> serviceFutures = new ArrayList<Future<Actuator>>();
        for (ServicesParametersConfig.Service service : this.servicesParametersConfig.getServices()) {
            serviceFutures.add(actuatorRespository.getService(service));
            log.debug("Request to host made: " + service.getHost());
        }

        List<Actuator> services = new ArrayList<Actuator>();
        for (Future<Actuator> service : serviceFutures) {
            try {
                services.add(service.get());
            } catch (Exception e) {
                log.error("Request to host failed");
            }
        }

        return services;
    }
}
