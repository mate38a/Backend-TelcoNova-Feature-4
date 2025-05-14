package com.Fabrica.TelcoNova.dto;

public class UpdateAlertInput {
    private String messageTemplate;
    private Boolean active;
    
    public UpdateAlertInput(){}
    public UpdateAlertInput(Boolean active, String messageTemplate) {
        this.active = active;
        this.messageTemplate = messageTemplate;
    }

    public String getMessageTemplate() {
        return messageTemplate;
    }

    public void setMessageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
