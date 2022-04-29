package com.recruitment.app.service.impl;

import com.recruitment.app.entity.Resume;
import com.recruitment.app.mapper.ResumeMapper;
import com.recruitment.app.repository.ResumeRepository;
import com.recruitment.app.request.ResumeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private ResumeMapper resumeMapper;

    public void addResumeToDb (ResumeRequest resumeRequest){

        Resume resume = resumeMapper.createResumeForDb(resumeRequest);
        resumeRepository.save(resume);


    }
}
