package com.recruitment.app.service.impl;

import com.recruitment.app.entity.JobDescription;
import com.recruitment.app.entity.Resume;
import com.recruitment.app.mapper.JobMapper;
import com.recruitment.app.repository.JobRepository;
import com.recruitment.app.response.JobResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository  jobRepository;

    @Autowired
    private JobMapper mapper;


    public void addJobToDb (MultipartFile jobFile,String jobDescription) throws IOException, SQLException {

        JobDescription jobToDb = mapper.createJobFromRequest(jobFile,jobDescription);

        jobRepository.save(jobToDb);

    }

    public List<JobResponse> getAllJobs (){
        List<JobResponse> jobResponseList = new ArrayList<>();



        return jobResponseList;
    }



}
