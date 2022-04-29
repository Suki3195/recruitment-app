package com.recruitment.app.mapper;

import com.recruitment.app.entity.Resume;
import com.recruitment.app.request.ResumeRequest;
import org.springframework.stereotype.Component;

@Component
public class ResumeMapper {

    public Resume createResumeForDb(ResumeRequest resumeRequest){

        return Resume.builder()
                .resume(resumeRequest.getResume())
                .taAssignedId(resumeRequest.getTaAssignedId())
                .build();

    }

}
