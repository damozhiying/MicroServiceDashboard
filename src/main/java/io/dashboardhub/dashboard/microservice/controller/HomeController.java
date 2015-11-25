package io.dashboardhub.dashboard.microservice.controller;

import io.dashboardhub.dashboard.microservice.service.ActuatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private ActuatorService actuatorService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String list(Model model) {

        model.addAttribute("services", this.actuatorService.getServices());

        return "list";
    }

    @Scheduled(fixedDelay = 1000)
    public void pushData() {
        this.messagingTemplate.convertAndSend(
                "/actuators/latest", this.actuatorService.getServices());
    }
}
