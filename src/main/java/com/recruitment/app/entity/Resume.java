package com.recruitment.app.entity;

import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Table(name="RESUME_DETAILS")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resume {

    @Id
//    IN ORACLE DB ID IS GENERATED BY DEFINED SEQUENCE AND TRIGGER IN DB SCHEMA
    @SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "RESUME_ID_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SequenceIdGenerator")
    private Integer resumeId;

    private Blob resume;

    private String taAssignedId;

    private String resumeStatus;

    private LocalDateTime createdDateTime;

    private LocalDateTime modifiedDateTime;

//    @ManyToOne
//    @JoinColumn(name="interview_id")
//    private Interview scheduledInterview;


}
