package com.firstBooting.ScaleApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentRequestDTO {
    String name;
    Long groupId;
//    String surName;
//    String groupName;
}
