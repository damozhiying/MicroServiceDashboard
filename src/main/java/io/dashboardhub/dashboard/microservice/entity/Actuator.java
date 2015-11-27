package io.dashboardhub.dashboard.microservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.Date;

//@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Actuator {

    private String id = "";

    private String host = "";

    private Integer memoryTotal = 0;

    private Integer memoryFree = 0;

    private Integer processors = 0;

    private Integer uptime = 0;

    private Integer instanceUptime = 0;

    private Double systemLoad = 0.0;

    private Date updatedOn = new Date();

    Actuator() {
    }

    public Actuator(String host) {
        this.host = host;
    }

    public Integer getMemory() {
        if (memoryFree == 0 || memoryTotal == 0) {
            return 0;
        }

        Integer memoryUsed = memoryTotal - memoryFree;

        Float percentage = (memoryUsed * 100.0f) / memoryTotal;

        return percentage.intValue();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @JsonIgnore
    public Integer getMemoryTotal() {
        return memoryTotal;
    }

    @JsonProperty("mem")
    public void setMemoryTotal(Integer memoryTotal) {
        this.memoryTotal = memoryTotal;
    }

    @JsonIgnore
    public Integer getMemoryFree() {
        return memoryFree;
    }

    @JsonProperty("mem.free")
    public void setMemoryFree(Integer memoryFree) {
        this.memoryFree = memoryFree;
    }

    public Integer getProcessors() {
        return processors;
    }

    public void setProcessors(Integer processors) {
        this.processors = processors;
    }

    public Integer getUptime() {
        return uptime;
    }

    public void setUptime(Integer uptime) {
        this.uptime = uptime;
    }

    @JsonProperty("instanceUptime")
    public Integer getInstanceUptime() {
        return instanceUptime;
    }

    @JsonProperty("instance.uptime")
    public void setInstanceUptime(Integer instanceUptime) {
        this.instanceUptime = instanceUptime;
    }

    @JsonProperty("systemLoad")
    public Double getSystemLoad() {
        return systemLoad;
    }

    @JsonProperty("systemload.average")
    public void setSystemLoad(Double systemLoad) {
        this.systemLoad = systemLoad;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
