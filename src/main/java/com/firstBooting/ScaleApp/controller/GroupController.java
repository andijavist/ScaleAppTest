package com.firstBooting.ScaleApp.controller;

import com.firstBooting.ScaleApp.dto.GroupsRequestDTO;
import com.firstBooting.ScaleApp.dto.GroupsResponseDTO;
import com.firstBooting.ScaleApp.service.interfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/groups")
public class GroupController {

    private final GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService) {
             this.groupService = groupService;
    }

    @PostMapping(path = "/add")
    public void addGroups(@RequestBody GroupsRequestDTO group)
    {
        groupService.add(group);
    }

    @GetMapping (path = "/getAll")
    public List<GroupsResponseDTO> getAll()
    {
        return groupService.getAll();
    }

}
