package com.recruitment.app.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name="INTERVIEW")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Interview {


    @Id
    private Integer interview_id;

    @ManyToOne
    private JobDescription jobDescription;

    @OneToMany(mappedBy = "scheduledInterview")
    private List<Resume> resumes;

    private String assignedHM;
    private String assignedIP;
    private Blob interviewTemplate;

    private String interviewFeedback;
    private String commentsHistory;
    private String zoomLink;
    private String status;


}
