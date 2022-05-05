package com.recruitment.app.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="SKILLS")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer skillId;

    private String skillName;

}
