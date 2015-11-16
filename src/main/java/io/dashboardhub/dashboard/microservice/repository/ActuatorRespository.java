package io.dashboardhub.dashboard.microservice.repository;

import io.dashboardhub.dashboard.microservice.entity.Actuator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ActuatorRespository {

//    @Autowired
//    RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(ActuatorRespository.class);

    public List<Actuator> getServices() {
        return this.generateData();
    }

    public List<Actuator> generateData() {

        Actuator actuator1 = new Actuator("Service 1a", new Date());
        actuator1.setProcessors(2);
        actuator1.setMemoryTotal(512);
        actuator1.setMemoryFree(128);
        actuator1.setInstanceUptime(250845874);
        actuator1.setUptime(61402078);
        actuator1.setSystemLoad(4.3);
        actuator1.setUpdatedOn(new Date());

        Actuator actuator2 = new Actuator("Service 2a", new Date());
        actuator2.setProcessors(4);
        actuator2.setMemoryTotal(1024);
        actuator2.setMemoryFree(512);
        actuator2.setInstanceUptime(250845874);
        actuator2.setUptime(61402078);
        actuator2.setSystemLoad(4.3);
        actuator2.setUpdatedOn(new Date());

        ArrayList<Actuator> services = new ArrayList<Actuator>();
        services.add(actuator1);
        services.add(actuator2);

        return services;
    }
}
