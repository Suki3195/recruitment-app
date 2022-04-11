package com.recruitment.app.entity;

import lombok.*;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;

@Entity
@Table(name="JOB_DESCRIPTION")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobDescribtion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer userId;

    private String ocrId;
    private String jdFile;
    private String jdShortName;
    private String description;
}
