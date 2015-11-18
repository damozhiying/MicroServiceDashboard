package io.dashboardhub.dashboard.microservice.service;

import io.dashboardhub.dashboard.microservice.entity.Actuator;
import io.dashboardhub.dashboard.microservice.repository.ActuatorRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ActuatorService {

    @Autowired
    private ActuatorRespository actuatorRespository;

    public List<Actuator> getServices() {
        List<Actuator> services = new ArrayList<Actuator>();

        // @TODO: Loop for configured Services
        services.add(actuatorRespository.getService());

        return services;
    }
}
