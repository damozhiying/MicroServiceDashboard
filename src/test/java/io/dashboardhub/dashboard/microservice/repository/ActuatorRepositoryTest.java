package io.dashboardhub.dashboard.microservice.repository;

import io.dashboardhub.dashboard.microservice.Config.ServicesParametersConfig;
import io.dashboardhub.dashboard.microservice.entity.Actuator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

import static org.junit.Assert.*;

public class ActuatorRepositoryTest {

    @InjectMocks
    ActuatorRepositoryImpl actuatorRepository;

    @Mock
    RestTemplate restTemplate;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetService() throws Exception {
        final String id = "testId";
        final String host = "testHost";
        final Integer processors = 4;

        ServicesParametersConfig.Service serviceConfig = new ServicesParametersConfig.Service();
        serviceConfig.setId(id);
        serviceConfig.setHost(host);

        Actuator actuator = new Actuator(host);
        actuator.setProcessors(processors);

        Mockito.when(this.restTemplate.getForObject(host, Actuator.class)).thenReturn(actuator);

        Future<Actuator> actuatorFuture = this.actuatorRepository.getService(serviceConfig);

        assertEquals(id, actuatorFuture.get().getId());
        assertEquals(host, actuatorFuture.get().getHost());
        assertEquals(processors, actuatorFuture.get().getProcessors());
    }
}
