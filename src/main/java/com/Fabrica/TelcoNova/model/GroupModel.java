package com.Fabrica.TelcoNova.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "groups")
public class GroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "group")
    private Set<UserGroupModel> users = new HashSet<>();

    public GroupModel() {
    }
    public GroupModel(Long id, String name, Set<UserGroupModel> users) {
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
    public Set<UserGroupModel> getUsers() {
        return users;
    }
    public void setUsers(Set<UserGroupModel> users) {
        this.users = users;
    }
    

    
}