package com.recruitment.app.controller;

import com.recruitment.app.entity.Interview;
import com.recruitment.app.request.InterviewRequest;
import com.recruitment.app.response.JobResponse;
import com.recruitment.app.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(path="/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @GetMapping("/getAllInterviews")
    public List<Interview> getAllJobs () throws SQLException {

        return interviewService.getAllInterviews();

    }

    @PostMapping()
    public void createInterview (@RequestBody InterviewRequest interviewRequest) throws SQLException{

        interviewService.createInterview(interviewRequest);


    }

}
