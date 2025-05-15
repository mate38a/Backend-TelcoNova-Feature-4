package com.Fabrica.TelcoNova.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.Fabrica.TelcoNova.model.RoleModel;
import com.Fabrica.TelcoNova.service.RoleService;

@Controller
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @QueryMapping 
    public List<RoleModel> getRoles() {
        return roleService.getRoles();
    }

    @MutationMapping
    public RoleModel createRole(@Argument String name) {
        return roleService.createRole(name);
    }
}
