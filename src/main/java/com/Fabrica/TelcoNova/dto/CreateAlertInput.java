package com.Fabrica.TelcoNova.dto;

public class CreateAlertInput {
    private Long eventId;
    private Long deliveryMethodId;
    private String messageTemplate;

    public CreateAlertInput(){
        
    }
    public CreateAlertInput(Long eventId, Long deliveryMethodId, String messageTemplate) {
        this.eventId = eventId;
        this.deliveryMethodId = deliveryMethodId;
        this.messageTemplate = messageTemplate;
    }
    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public Long getDeliveryMethodId() {
        return deliveryMethodId;
    }
    public void setDeliveryMethodId(Long deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }
    public String getMessageTemplate() {
        return messageTemplate;
    }
    public void setMessageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    
}
