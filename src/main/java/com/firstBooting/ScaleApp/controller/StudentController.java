package com.firstBooting.ScaleApp.controller;

import com.firstBooting.ScaleApp.dto.StudentRequestDTO;
import com.firstBooting.ScaleApp.dto.StudentResponseDTO;
import com.firstBooting.ScaleApp.service.implem.StudentService1;
import com.firstBooting.ScaleApp.service.interfaces.GroupService;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService1 studentService;
    private final GroupService groupService;

    @Autowired
    public StudentController(StudentService1 studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }


    @PostMapping(path = "/add")
    public void add(@RequestBody StudentRequestDTO studentRequestDTO)
    {
        studentService.add(studentRequestDTO);

    }

    @GetMapping(path ="/getStudentByGroupId/{groupId}"/*, produces = MediaType.TEXT_HTML_VALUE*/)
    public ResponseEntity<List<StudentResponseDTO>> getStudentByGroup(@PathVariable Long groupId/*, HttpServletResponse response*/)
    {
        List<StudentResponseDTO> studentsByGroupId = studentService.getStudentsByGroupId(groupId);
//        Template template = null;
//        ModelMap modelMap = new ModelMap();
//        String groupName = groupService.getGroupNameById(groupId).getGroupName();
//        modelMap.addAttribute("groupName",groupName);
//        modelMap.addAttribute("groupId",groupId);
//        modelMap.addAttribute("studentList",groupId);
    return ResponseEntity
                         .ok()
                         .body(studentsByGroupId);
    }
}
