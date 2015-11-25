package io.dashboardhub.dashboard.microservice.service;

import io.dashboardhub.dashboard.microservice.entity.Actuator;

import java.util.List;

public interface ActuatorService {

    List<Actuator> getServices();
}
