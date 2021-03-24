package com.firstBooting.ScaleApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class StudentResponseDTO {
    Long id;
    String name;
    String surname;
    LocalDate createdAt;
    String groupName;
}
