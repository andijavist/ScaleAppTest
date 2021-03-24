package com.firstBooting.ScaleApp.service.implem;

import com.firstBooting.ScaleApp.Entity.Groups;
import com.firstBooting.ScaleApp.dto.GroupsRequestDTO;
import com.firstBooting.ScaleApp.dto.GroupsResponseDTO;
import com.firstBooting.ScaleApp.repository.GroupRepository;
import com.firstBooting.ScaleApp.service.interfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService1 implements GroupService {

    GroupRepository groupRepository;

    @Autowired
    public GroupService1(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public void add(GroupsRequestDTO group) {
    groupRepository.save(getGroupFromRequestDTO(group));
    }

    //метод, возвращающий группы
    @Override
    public List<GroupsResponseDTO> getAll() {
        return   groupRepository.findAll()
                 .stream()
                 .map(this::getGroupsResponseDTOFromGroup)
                 //строчка сверху равна этой group -> getGroupsResponseDTOFromGroup(group)//
                 .collect(Collectors.toList());
    }

    //метод-конвертор ДТО из Группы
    private GroupsResponseDTO getGroupsResponseDTOFromGroup(Groups group) {
            return GroupsResponseDTO.builder()
                                    .groupName(group.getName())
                                    .quantity(group.getStudents().size())
                                    .build();
    }


    //метод-конвертор Группа из ДТО
    private Groups getGroupFromRequestDTO(GroupsRequestDTO group){
        return Groups.builder()
                     .name(group.getGroupName())
                     .createdAt(LocalDate.now())
                     .build();
    }
}
