package com.recruitment.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/resume")
public class UploadResumeController {


    @PostMapping("/uploadResume")
    public String addUserRole (){

        return "Upload Your Resume !!";

    }
}
