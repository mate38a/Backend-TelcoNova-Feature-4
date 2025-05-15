package com.Fabrica.TelcoNova.dto;

import java.util.List;

import com.Fabrica.TelcoNova.model.UserModel;

public class GroupWithUsersDTO {
    private Long id;
    private String name;
    private List<UserModel> users;

    public GroupWithUsersDTO(){}
    public GroupWithUsersDTO(Long id, String name, List<UserModel> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<UserModel> getUsers() {
        return users;
    }
    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    
    
}
