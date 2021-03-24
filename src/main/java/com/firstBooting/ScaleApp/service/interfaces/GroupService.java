package com.firstBooting.ScaleApp.service.interfaces;
import com.firstBooting.ScaleApp.dto.GroupsRequestDTO;
import com.firstBooting.ScaleApp.dto.GroupsResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    void add(GroupsRequestDTO group);
    List<GroupsResponseDTO> getAll();
}
