package com.recruitment.app.controller;

import com.recruitment.app.request.ResumeRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/resume")
public class UploadResumeController {


    @PostMapping("/uploadResume")
    public String addResume(@RequestBody ResumeRequest resumeRequest){


        return "Upload Your Resume !!";

    }
}
