package com.recruitment.app.service.impl;

import com.recruitment.app.entity.Resume;
import com.recruitment.app.mapper.ResumeMapper;
import com.recruitment.app.repository.ResumeRepository;
import com.recruitment.app.response.ResumeResponse;
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
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private ResumeMapper resumeMapper;

    public void addResumeToDb (MultipartFile resume,String taAssignedId) throws IOException, SQLException {

        Resume resumeToDb = resumeMapper.createResumeForDb(resume,taAssignedId);

        resumeRepository.save(resumeToDb);


    }

    public List<ResumeResponse> getAllResumes() throws SQLException {
        List<Resume> resumesInDb = (List<Resume>) resumeRepository.findAll();
        List<ResumeResponse> resumeResponses = new ArrayList<>();
        for (Resume resume : resumesInDb){
            ResumeResponse response = resumeMapper.createResumeResponse(resume);
            resumeResponses.add(response);
        }
        return resumeResponses;
    }
}
