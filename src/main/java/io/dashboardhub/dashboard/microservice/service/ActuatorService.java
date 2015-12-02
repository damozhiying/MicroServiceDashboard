package io.dashboardhub.dashboard.microservice.service;

import io.dashboardhub.dashboard.microservice.Config.ServicesConfig;
import io.dashboardhub.dashboard.microservice.entity.Actuator;
import io.dashboardhub.dashboard.microservice.repository.ActuatorRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

@org.springframework.stereotype.Service
@EnableAsync
public class ActuatorService {

    @Autowired
    private ServicesConfig servicesConfig;

    @Autowired
    private ActuatorRespository actuatorRespository;

    private static final Logger log = LoggerFactory.getLogger(ActuatorService.class);

    public List<Actuator> getServices() {
        List<Future<Actuator>> serviceFutures = new ArrayList<Future<Actuator>>();
        for (Iterator<String> host = servicesConfig.getServices().iterator(); host.hasNext(); ) {
            String url = host.next();
            serviceFutures.add(actuatorRespository.getService(url));
            log.debug("Request to host made: " + url);
        }

        List<Actuator> services = new ArrayList<Actuator>();
        for (Iterator<Future<Actuator>> service = serviceFutures.iterator(); service.hasNext(); ) {
            try {
                services.add(service.next().get());
            } catch (Exception e) {
                log.error("Request to host failed");
            }
        }

        return services;
    }
}
