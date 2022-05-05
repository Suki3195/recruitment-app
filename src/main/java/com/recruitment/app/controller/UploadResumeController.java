package com.recruitment.app.controller;

import com.recruitment.app.response.ResumeResponse;
import com.recruitment.app.service.impl.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(path="/resume")
public class UploadResumeController {

    @Autowired
    private ResumeService resumeService ;

    @PostMapping(value="/uploadResume",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addResume(@RequestParam("resume") MultipartFile resume,
                            @RequestParam("taAssignedId") String taAssignedId  ) throws IOException, SQLException {

        System.out.println("RESUME IS AS  :-  " + resume.getBytes());


        String[]  taId= taAssignedId.split(",");

        System.out.println("TA ID IS AS  :-  " + taId[0]);

        resumeService.addResumeToDb(resume,taId[0]);

        return "RESUME_ADDED";

    }



    @GetMapping("/getAllResumes")
    public List<ResumeResponse> getAllUser () throws SQLException {

        return resumeService.getAllResumes();

    }

}
