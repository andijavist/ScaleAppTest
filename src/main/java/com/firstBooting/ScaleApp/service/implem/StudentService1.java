package com.firstBooting.ScaleApp.service.implem;

import com.firstBooting.ScaleApp.Entity.Groups;
import com.firstBooting.ScaleApp.Entity.Students;
import com.firstBooting.ScaleApp.dto.StudentRequestDTO;
import com.firstBooting.ScaleApp.dto.StudentResponseDTO;
import com.firstBooting.ScaleApp.repository.GroupRepository;
import com.firstBooting.ScaleApp.repository.StudentRepository;
import com.firstBooting.ScaleApp.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService1 implements StudentService {



    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public StudentService1(StudentRepository studentRepository, GroupRepository groupRepository) {

        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    //метод, добавляющий студентов
    @Override
    public void add(StudentRequestDTO studentRequestDTO)
    {
        studentRepository.save(getStudentFromStudentRequestDTO(studentRequestDTO));
    }

    //метод, возвращающий лист студентов
    @Override
    public List<StudentResponseDTO> getStudentsByGroupId(Long groupId) {
         return studentRepository.findAllByGroupId(groupId)
                .stream()
                .map(students -> getStudentResponseDTOFromStudent(students))
                .collect(Collectors.toList());
    }

    //метод-билдер StudentResponseDTO
    private StudentResponseDTO getStudentResponseDTOFromStudent(Students students) {
        return StudentResponseDTO
                .builder()
                .name(students.getName())
                .surname(students.getSurName())
                .createdAt(students.getDobavlenV())
                .build();
    }

    //метод getStudentFromStudentRequestDTO для конвертации StudentRequestDTO в Students
    private Students getStudentFromStudentRequestDTO(StudentRequestDTO studentRequestDTO){
        return Students
                       .builder()
                       .name(studentRequestDTO.getName())
                       .group(groupRepository.findById(studentRequestDTO.getGroupId()).
                                              orElseThrow(()->
                                              {throw new IllegalStateException("ЗАДАН НЕСУЩЕСТВУЮЩИЙ ID ГРУППЫ");
    //метод findById возвращает обертку Optional, поэтому мы должны обработать исключение, если внутри Optional будет null
                                              })
                             )
                       .build();
    }
}
