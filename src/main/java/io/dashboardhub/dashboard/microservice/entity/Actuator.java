package io.dashboardhub.dashboard.microservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Actuator {

    private String name;
    private Integer memoryTotal;
    private Integer memoryFree;
    private Integer processors;
    private Integer uptime;
    private Integer instanceUptime;
    private Double systemLoad;
    private Date updatedOn;

    Actuator() {
    }

    public Actuator(String name, Date updatedOn) {
        this.name = name;
        this.updatedOn = updatedOn;
    }

    public Integer getMemory() {
        if (memoryFree == 0 || memoryTotal == 0) {
            return 0;
        }

        Integer memoryUsed = memoryTotal - memoryFree;

        Integer percentage = (int) (memoryUsed * 100.0f) / memoryTotal;

        return percentage;
    }
}
