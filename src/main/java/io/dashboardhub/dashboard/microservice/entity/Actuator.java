package io.dashboardhub.dashboard.microservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Actuator {

    private String name = "";

    @JsonProperty("mem")
    private Integer memoryTotal = 0;

    @JsonProperty("mem.free")
    private Integer memoryFree = 0;

    private Integer processors = 0;

    private Integer uptime = 0;

    @JsonProperty("instance.uptime")
    private Integer instanceUptime = 0;

    @JsonProperty("systemload.average")
    private Double systemLoad = 0.0;

    private Date updatedOn = new Date();

    Actuator() {
    }

    public Actuator(String name) {
        this.name = name;
    }

    public Integer getMemory() {
        if (memoryFree == 0 || memoryTotal == 0) {
            return 0;
        }

        Integer memoryUsed = memoryTotal - memoryFree;

        Float percentage = (memoryUsed * 100.0f) / memoryTotal;

        return percentage.intValue();
    }
}
