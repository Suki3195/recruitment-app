package com.recruitment.app.repository;

import com.recruitment.app.entity.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository  extends CrudRepository<Skill, Integer> {


}
