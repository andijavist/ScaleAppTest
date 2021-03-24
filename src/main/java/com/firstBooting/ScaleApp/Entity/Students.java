package com.firstBooting.ScaleApp.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String surName;
    LocalDate dobavlenV;

    @ManyToOne
    @JoinColumn (name = "group_id", foreignKey = @ForeignKey(name="student_to_group"))
    Groups group;
}
