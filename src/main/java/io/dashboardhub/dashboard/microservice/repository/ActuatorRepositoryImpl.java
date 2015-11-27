package io.dashboardhub.dashboard.microservice.repository;

import io.dashboardhub.dashboard.microservice.Config.ServicesParametersConfig;
import io.dashboardhub.dashboard.microservice.entity.Actuator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Repository
public class ActuatorRepositoryImpl implements ActuatorRepository {

    @Autowired
    RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(ActuatorRepository.class);

    @Async
    public Future<Actuator> getService(ServicesParametersConfig.Service service) {
        Actuator actuator = restTemplate.getForObject(service.getHost(), Actuator.class);
        actuator.setId(service.getId());
        actuator.setHost(service.getHost());

        log.debug(actuator.toString());

        return new AsyncResult<Actuator>(actuator);
    }
}
