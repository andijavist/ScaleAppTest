package com.firstBooting.ScaleApp.service.interfaces;

import com.firstBooting.ScaleApp.dto.StudentRequestDTO;
import com.firstBooting.ScaleApp.dto.StudentResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {
    void add(StudentRequestDTO studentRequestDTO);

    List<StudentResponseDTO> getStudentsByGroupId(Long groupId);
}
