package com.Fabrica.TelcoNova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios_grupos")
public class UserGroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Nueva clave primaria simple

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private GroupModel group;

    // Constructor, getters y setters

    public UserGroupModel() {
    }

    public UserGroupModel(Long id, UserModel user, GroupModel group) {
        this.id = id;
        this.user = user;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public GroupModel getGroup() {
        return group;
    }

    public void setGroup(GroupModel group) {
        this.group = group;
    }
}
