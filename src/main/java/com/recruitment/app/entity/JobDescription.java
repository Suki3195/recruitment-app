package com.recruitment.app.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name="JOB_DESCRIPTION")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer jobId;

    private Blob jdFile;
    private String jdShortName;
    private String description;
    private String skill;
    private String subSkills;


}
