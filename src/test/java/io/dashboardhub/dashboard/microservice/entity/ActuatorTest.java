package io.dashboardhub.dashboard.microservice.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class ActuatorTest {

    private String host = "TestHost";

    private Actuator actuator = new Actuator(this.host);

    @Test
    public void testHostConstruct() throws Exception {
        assertEquals(this.host, this.actuator.getHost());
    }

    @Test
    public void testId() throws Exception {
        final String id = "test id";

        this.actuator.setId(id);

        assertEquals(id, this.actuator.getId());
    }

    @Test
    public void testHost() throws Exception {
        final String host = "test host";

        this.actuator.setHost(host);

        assertEquals(host, this.actuator.getHost());
    }

    @Test
    public void testMemoryTotal() throws Exception {
        final Integer memoryTotal = 123;

        this.actuator.setMemoryTotal(memoryTotal);

        assertEquals(memoryTotal, this.actuator.getMemoryTotal());
    }

    @Test
    public void testMemoryFree() throws Exception {
        final Integer memoryFree = 123;

        this.actuator.setMemoryFree(memoryFree);

        assertEquals(memoryFree, this.actuator.getMemoryFree());
    }

    @Test
    public void testMemory() throws Exception {
        final Integer memory = 50;
        final Integer memoryFree = 500;
        final Integer memoryTotal = 1000;

        this.actuator.setMemoryFree(memoryFree);
        this.actuator.setMemoryTotal(memoryTotal);

        assertEquals(memory, this.actuator.getMemory());
    }

    @Test
    public void testProcessors() throws Exception {
        final Integer processors = 4;

        this.actuator.setProcessors(processors);

        assertEquals(processors, this.actuator.getProcessors());
    }

    @Test
    public void testUptime() throws Exception {
        final Integer uptime = 123;

        this.actuator.setUptime(uptime);

        assertEquals(uptime, this.actuator.getUptime());
    }

    @Test
    public void testInstanceUptime() throws Exception {
        final Integer uptime = 123;

        this.actuator.setInstanceUptime(uptime);

        assertEquals(uptime, this.actuator.getInstanceUptime());
    }

    @Test
    public void testSystemLoad() throws Exception {
        final Double load = 1.23;

        this.actuator.setSystemLoad(load);

        assertEquals(load, this.actuator.getSystemLoad());
    }
}
