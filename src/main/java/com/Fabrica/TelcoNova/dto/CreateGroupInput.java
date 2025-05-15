package com.Fabrica.TelcoNova.dto;

import java.util.List;

public class CreateGroupInput {
    private String name;
    private List<Long> users;

    public CreateGroupInput() {
    }
    public CreateGroupInput(String name, List<Long> users) {
        this.name = name;
        this.users = users;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Long> getUsers() {
        return users;
    }
    public void setUsers(List<Long> users) {
        this.users = users;
    }

    
}
