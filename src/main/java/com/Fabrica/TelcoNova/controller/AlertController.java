package com.Fabrica.TelcoNova.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.Fabrica.TelcoNova.model.AlertModel;
import com.Fabrica.TelcoNova.service.AlertService;
import com.Fabrica.TelcoNova.dto.*;

@Controller
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @MutationMapping
    public AlertModel createAlert(@Argument CreateAlertInput input) {
        return alertService.createAlert(input);
    }

    @MutationMapping
    public boolean updateAlert(@Argument Long id, @Argument UpdateAlertInput input) {
        return alertService.updateAlert(id, input);
    }

    @MutationMapping
    public boolean deleteAlert(@Argument Long id) {
        return alertService.deleteAlert(id);
    }

    
    @QueryMapping
    public List<AlertModel> getAlerts() {
        return alertService.getAlerts();
    }

    @QueryMapping
    public AlertModel getAlertById(@Argument Long id) {
        return alertService.getAlertById(id);
    }
}
