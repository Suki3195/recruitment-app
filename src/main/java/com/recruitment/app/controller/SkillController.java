package com.recruitment.app.controller;

import com.recruitment.app.service.impl.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/requirement")
public class SkillController {


    @Autowired
    private SkillService service;

    @GetMapping("/getAllSkills")
    public List<String> getAllSkills (){


        return service.getAllSkills();

    }


    @GetMapping("/getSubSkills")
    public List<String> getSubSkills (@RequestParam String skill){


        return service.getSubSkillsForGivenSkill(skill);

    }

}
