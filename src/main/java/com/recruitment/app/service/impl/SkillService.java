package com.recruitment.app.service.impl;


import com.recruitment.app.entity.Skill;
import com.recruitment.app.entity.SubSkill;
import com.recruitment.app.repository.SkillRepository;
import com.recruitment.app.repository.SubSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {


    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SubSkillRepository subSkillRepository;


    public List<String> getAllSkills(){
        List<Skill> skills = (List<Skill>) skillRepository.findAll();

        List<String> skillNames = new ArrayList<>();

        for (Skill skill: skills) {
            skillNames.add(skill.getSkillName());
        }
        return skillNames;

    }


    public List<String> getSubSkillsForGivenSkill( String skill){
        List<SubSkill> subSkills = subSkillRepository.findBySkillName(skill);

        List<String> subSkillNames = new ArrayList<>();

        for (SubSkill subSkill: subSkills) {
            subSkillNames.add(subSkill.getSubSkillName());
        }
        return subSkillNames;

    }

}
