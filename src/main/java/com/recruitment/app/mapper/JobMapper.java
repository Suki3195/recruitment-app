package com.recruitment.app.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruitment.app.entity.JobDescription;
import com.recruitment.app.entity.Resume;
import com.recruitment.app.request.JobRequest;
import com.recruitment.app.response.JobResponse;
import com.recruitment.app.response.ResumeResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class JobMapper {

    public JobDescription createJobFromRequest(MultipartFile jobFile, String jobDescription) throws SQLException, IOException {

        JobRequest jobDetails = new ObjectMapper().readValue(jobDescription, JobRequest.class);

        System.out.println("JOB DETAILS IN MAPPER IS AS  :- " + jobDetails.getSubSkills());
        byte[] contents = jobFile.getBytes();
        Blob blob = new SerialBlob(contents);

        return JobDescription.builder()
                .jdShortName(jobDetails.getJdShortName())
                .ocrId(jobDetails.getOcrId())
                .description(jobDetails.getJdDescription())
                .jdFile(blob)
                .jobStatus("CREATED")
                .skill(jobDetails.getSkill())
                .subSkills("MongoDb")
                .createdDateTime(LocalDateTime.now())
                .modifiedDateTime(LocalDateTime.now())
                .build();

    }

    private String getSubSkills (List<String> subSkills){
        StringBuilder subSkillsString = new StringBuilder();
        for(String subSkill : subSkills){
            subSkillsString.append(subSkill + " , ");
        }
        return subSkillsString.toString();
    }



    public JobResponse createJobResponse (JobDescription jobFromDB) throws SQLException {

        Blob blob = new SerialBlob(jobFromDB.getJdFile());
//        byte[] contents = blob.getBytes();

        return JobResponse.builder()
                .ocrId(jobFromDB.getOcrId())
                .jd(blob)
                .skill(jobFromDB.getSkill())
                .jdDescription(jobFromDB.getDescription())
                .jdShortName(jobFromDB.getJdShortName())
                .subSkills(jobFromDB.getSubSkills())
                .build();

    }

}
