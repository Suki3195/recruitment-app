package com.recruitment.app.repository;

import com.recruitment.app.entity.Skill;
import com.recruitment.app.entity.SubSkill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubSkillRepository extends CrudRepository<SubSkill, Integer> {

    List<SubSkill> findBySkillName(String skillName);

}
