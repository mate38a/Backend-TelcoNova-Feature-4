package com.Fabrica.TelcoNova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fabrica.TelcoNova.dto.CreateRoleInput;
import com.Fabrica.TelcoNova.model.RoleModel;
import com.Fabrica.TelcoNova.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public RoleModel getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);  
    }
    public List<RoleModel> getRoles() {
        return roleRepository.findAll();  
    }
    public RoleModel createRole(CreateRoleInput input) {
        RoleModel role = new RoleModel();
        role.setName(input.getName());
        
        return roleRepository.save(role);
    }

}
