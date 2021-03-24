package com.firstBooting.ScaleApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstBooting.ScaleApp.Entity.Groups;
import com.firstBooting.ScaleApp.dto.StudentRequestDTO;
import com.firstBooting.ScaleApp.repository.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;//статический импорт метода post()
@Transactional
@SpringBootTest//запуск приложения перед проведением теста
@AutoConfigureMockMvc//стандартная конфигурация бина MockMvc
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    GroupRepository groupRepository;
    Groups group;

    //конвертор json в string //jackson
    @Autowired
    ObjectMapper objectMapper;


@BeforeEach
//сетап, исходные данные для теста, выполняется перед каждым запуском теста
    void setUp(){
        group = Groups
             .builder()
             .name("English")
             .createdAt(LocalDate.now())
             .build();
        groupRepository.save(group);
    }
    @Test
    void add() throws Exception {
        StudentRequestDTO studRequestDTO = StudentRequestDTO.builder()
                .groupId(group.getId())
                .name("Test")
                .build();


        String jsonFromStudentRequestDTOStr = objectMapper.writeValueAsString(studRequestDTO);//тело тестового post-запроса в виде строки
        mockMvc.perform(//исполнить post-запрос, далее описание постзапроса
                post("/student/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonFromStudentRequestDTOStr))
                .andExpect(
                        //класс для контроля
                        MockMvcResultMatchers.status().isOk());
}
}