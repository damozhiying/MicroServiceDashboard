package io.dashboardhub.dashboard.microservice.repository;

import io.dashboardhub.dashboard.microservice.entity.Actuator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ActuatorRespository {

    @Autowired
    RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(ActuatorRespository.class);

    public Actuator getService() {
        Actuator actuator = restTemplate.getForObject("http://localhost:8082/metrics", Actuator.class);

        log.debug(actuator.toString());

        return actuator;
    }
}
