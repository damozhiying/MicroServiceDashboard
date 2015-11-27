package io.dashboardhub.dashboard.microservice.repository;

import io.dashboardhub.dashboard.microservice.Config.ServicesParametersConfig;
import io.dashboardhub.dashboard.microservice.entity.Actuator;

import java.util.concurrent.Future;

public interface ActuatorRepository {

    Future<Actuator> getService(ServicesParametersConfig.Service service);
}
