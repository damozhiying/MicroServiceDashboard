package io.dashboardhub.dashboard.microservice.service;

import io.dashboardhub.dashboard.microservice.Config.ServicesConfig;
import io.dashboardhub.dashboard.microservice.entity.Actuator;
import io.dashboardhub.dashboard.microservice.repository.ActuatorRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@org.springframework.stereotype.Service
public class ActuatorService {

    @Autowired
    private ServicesConfig servicesConfig;

    @Autowired
    private ActuatorRespository actuatorRespository;

    public List<Actuator> getServices() {
        List<Actuator> services = new ArrayList<Actuator>();

        for (Iterator<String> service = servicesConfig.getServices().iterator(); service.hasNext(); ) {
            services.add(actuatorRespository.getService(service.next()));
        }

        return services;
    }
}
