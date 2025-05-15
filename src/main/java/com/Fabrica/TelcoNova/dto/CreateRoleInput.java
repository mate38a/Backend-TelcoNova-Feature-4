package com.Fabrica.TelcoNova.dto;

public class CreateRoleInput {
    private String name;

    public CreateRoleInput() {
    }
    public CreateRoleInput(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
