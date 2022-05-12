package com.recruitment.app.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InterviewRequest {

    private JobRequest jobRequest;
    private ResumeRequest  resumeRequest;
}
