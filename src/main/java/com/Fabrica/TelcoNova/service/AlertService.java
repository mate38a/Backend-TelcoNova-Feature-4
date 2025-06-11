package com.Fabrica.TelcoNova.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Fabrica.TelcoNova.dto.CreateAlertInput;
import com.Fabrica.TelcoNova.dto.UpdateAlertInput;
import com.Fabrica.TelcoNova.model.AlertModel;
import com.Fabrica.TelcoNova.repository.AlertRepository;
import com.Fabrica.TelcoNova.repository.DeliveryMethodRepository;
import com.Fabrica.TelcoNova.repository.EventRepository;

@Service
public class AlertService {
    // Constante para el mensaje de error duplicado
    private static final String ALERT_NOT_FOUND_MSG = "Alerta no encontrada";
    
    private final AlertRepository alertRepository;
    private final EventRepository eventRepository;
    private final DeliveryMethodRepository deliveryMethodRepository;

    // Constructor para inyección de dependencias (ya corregido)
    public AlertService(
        AlertRepository alertRepository,
        EventRepository eventRepository,
        DeliveryMethodRepository deliveryMethodRepository
    ) {
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
        // Usando la constante en lugar del literal duplicado
        AlertModel alert = alertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(ALERT_NOT_FOUND_MSG));
        
        if (input.getMessageTemplate() != null) 
            alert.setMessageTemplate(input.getMessageTemplate());
        if (input.getActive() != null) 
            alert.setActive(input.getActive());
        
        alertRepository.save(alert);
        return true;
    }

    public boolean deleteAlert(Long id) {
        // Usando la constante en lugar del literal duplicado
        AlertModel alert = alertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(ALERT_NOT_FOUND_MSG));
        
        alertRepository.delete(alert);
        return true;
    }

    public List<AlertModel> getAlerts() {
        return alertRepository.findAll();
    }

    public AlertModel getAlertById(Long id) {
        // Usando la constante en lugar del literal duplicado
        return alertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(ALERT_NOT_FOUND_MSG));
    }
}