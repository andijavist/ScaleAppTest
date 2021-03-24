package com.firstBooting.ScaleApp.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GroupsResponseDTO {
    Long id;
    String groupName;
    int quantity;//количество
}
