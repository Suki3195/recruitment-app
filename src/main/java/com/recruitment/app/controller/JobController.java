package com.recruitment.app.controller;

import com.recruitment.app.response.JobResponse;
import com.recruitment.app.service.impl.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(path="/job")
public class JobController {

    @Autowired
    private JobService jobService ;

    @PostMapping(value="/uploadJob",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addResume(@RequestParam("jobFile") MultipartFile jobFile,
                                @RequestParam("jobRequest") String jobRequest  ) throws IOException, SQLException {

        System.out.println("JOB IS AS  :-  " + jobFile.getBytes());


        String jobRequestString = jobRequest.toString();
//        System.out.println("Job Details :-  " + taId);
        System.out.println("jobRequestString IS AS  :-  " + jobRequestString);


        jobService.addJobToDb(jobFile, jobRequest);

        return "JOB_ADDED";

    }



    @GetMapping("/getAllJobs")
    public List<JobResponse> getAllJobs () throws SQLException {

        return jobService.getAllJobs();

    }
}
