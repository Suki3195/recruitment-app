package com.recruitment.app.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResumeRequest {

    private String resumeId;
    private String taAssignedId;
    private String status;
    private Blob resume;




}
