package com.recruitment.app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="SUB_SKILL")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubSkill {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer subSkillId;

    private String skillName;

    private String subSkillName;


}
