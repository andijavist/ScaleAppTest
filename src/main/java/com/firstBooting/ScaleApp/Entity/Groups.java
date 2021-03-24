package com.firstBooting.ScaleApp.Entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    @OneToMany (mappedBy = "group",
                cascade = CascadeType.DETACH,
                fetch = FetchType.LAZY)
    Set<Students> students;
    LocalDate createdAt;


}
