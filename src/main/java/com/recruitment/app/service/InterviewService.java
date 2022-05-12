package com.recruitment.app.service;


import com.recruitment.app.entity.Interview;
import com.recruitment.app.repository.InterviewRepository;
import com.recruitment.app.request.InterviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {


    @Autowired
    private InterviewRepository repository;

    public List<Interview> getAllInterviews(){

        List<Interview> interiewList = (List<Interview>) repository.findAll();
        return interiewList;

    }

    public void createInterview (InterviewRequest interviewRequest){
        

    }

    public void updateInterviewDetails (){


    }

}
