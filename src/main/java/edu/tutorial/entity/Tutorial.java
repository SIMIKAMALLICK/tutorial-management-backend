package edu.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alltutorial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
    private boolean publish_status;
}
