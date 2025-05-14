package com.Fabrica.TelcoNova.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Fabrica.TelcoNova.dto.UpdateAlertInput;
import com.Fabrica.TelcoNova.dto.CreateAlertInput;
import com.Fabrica.TelcoNova.model.AlertModel;
import com.Fabrica.TelcoNova.repository.AlertRepository;
import com.Fabrica.TelcoNova.repository.DeliveryMethodRepository;
import com.Fabrica.TelcoNova.repository.EventRepository;

@Service
public class AlertService {
    private final AlertRepository alertRepository;
    private final EventRepository eventRepository;
    private final DeliveryMethodRepository deliveryMethodRepository;

    public AlertService(AlertRepository alertRepository, EventRepository eventRepository, DeliveryMethodRepository deliveryMethodRepository) {
        this.alertRepository = alertRepository;
        this.eventRepository = eventRepository;
        this.deliveryMethodRepository = deliveryMethodRepository;
    }

    public AlertModel createAlert(CreateAlertInput input) {
        AlertModel alert = new AlertModel();
        alert.setMessageTemplate(input.getMessageTemplate());
        alert.setCreatedAt(LocalDateTime.now());
        alert.setEvent(eventRepository.findById(input.getEventId())
                .orElseThrow(() -> new RuntimeException("Evento no encontrado")));
        alert.setDeliveryMethod(deliveryMethodRepository.findById(input.getDeliveryMethodId())
                .orElseThrow(() -> new RuntimeException("Método de entrega no encontrado")));
        return alertRepository.save(alert);
    }

    public boolean updateAlert(Long id, UpdateAlertInput input) {
        AlertModel alert = alertRepository.findById(id).orElseThrow(() -> new RuntimeException("Alerta no encontrada"));
        if (input.getMessageTemplate() != null) alert.setMessageTemplate(input.getMessageTemplate());
        if (input.getActive() != null) alert.setActive(input.getActive());
        alertRepository.save(alert);
        return true;
    }

    public boolean deleteAlert(Long id) {
        AlertModel alert = alertRepository.findById(id).orElseThrow(() -> new RuntimeException("Alerta no encontrada"));
        alertRepository.delete(alert);
        return true;
    }

    public List<AlertModel> getAlerts() {
        return alertRepository.findAll();
    }

    public AlertModel getAlertById(Long id) {
        return alertRepository.findById(id).orElseThrow(() -> new RuntimeException("Alerta no encontrada"));
    }
}

