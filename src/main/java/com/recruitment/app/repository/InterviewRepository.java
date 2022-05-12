package com.recruitment.app.repository;

import com.recruitment.app.entity.Interview;
import com.recruitment.app.entity.JobDescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends CrudRepository<Interview, Integer> {
}
