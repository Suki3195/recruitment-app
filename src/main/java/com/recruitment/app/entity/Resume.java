package com.recruitment.app.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="RESUME")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // auto generated
    private Integer resumeId;

    private Blob resume;

    private String taAssignedId;

    private String resumeStatus;


}
