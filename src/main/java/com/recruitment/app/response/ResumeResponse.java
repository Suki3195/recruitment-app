package com.recruitment.app.response;

import lombok.*;

import java.sql.Blob;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResumeResponse {

    private Blob resume;
    private String taAssignedId;
    private Integer resumeId;
    private String status;

}
