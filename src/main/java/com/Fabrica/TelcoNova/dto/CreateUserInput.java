package com.Fabrica.TelcoNova.dto;

public class CreateUserInput {
    private String name;
    private String email;
    private String phone;
    private String address;
    private Long roleId;

    public CreateUserInput(){
        
    }
    public CreateUserInput(String name, String email, String phone, String address, Long roleId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.roleId = roleId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    } 

    
}
