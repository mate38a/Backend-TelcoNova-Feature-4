package com.Fabrica.TelcoNova.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.Fabrica.TelcoNova.dto.CreateGroupInput;
import com.Fabrica.TelcoNova.dto.GroupWithUsersDTO;
import com.Fabrica.TelcoNova.model.GroupModel;
import com.Fabrica.TelcoNova.service.GroupService;


@Controller
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @QueryMapping
    public List<GroupModel> getAllGroups() {
        return groupService.getAllGroups();
    }

    @QueryMapping
    public GroupModel getGroupById(@Argument Long id) {
        return groupService.getGroupById(id);
    }

    @QueryMapping
    public List<GroupWithUsersDTO> getAllGroupsWithUsers() {
        return groupService.getAllGroupsWhitUsers();
    }

    @MutationMapping
    public GroupModel createGroup(@Argument CreateGroupInput input) {
        return groupService.CreateGroup(input);
    }

    @MutationMapping
    public GroupModel addUserToGroup(@Argument Long groupId, @Argument Long userId) {
        return groupService.addUserToGroup(groupId, userId);
    }
}
