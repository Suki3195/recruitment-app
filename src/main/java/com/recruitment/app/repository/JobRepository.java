package com.recruitment.app.repository;

import com.recruitment.app.entity.JobDescription;
import com.recruitment.app.entity.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<JobDescription, Integer> {
}
