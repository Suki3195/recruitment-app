package com.recruitment.app.mapper;

import com.recruitment.app.entity.Resume;
import com.recruitment.app.response.ResumeResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class ResumeMapper {

    public Resume createResumeForDb(MultipartFile resume, String taAssignedId) throws IOException, SQLException {

        byte[] contents = resume.getBytes();
        Blob blob = new SerialBlob(contents);

        return Resume.builder()
                .resume(blob)
                .taAssignedId(taAssignedId)
                .resumeStatus("UPLOADED")
                .modifiedDateTime(LocalDateTime.now())
                .createdDateTime(LocalDateTime.now())
                .build();
    }

    public ResumeResponse createResumeResponse (Resume resume) throws SQLException {

        Blob blob = new SerialBlob(resume.getResume());
//        byte[] contents = blob.getBytes();

        return ResumeResponse.builder()
                .taAssignedId(resume.getTaAssignedId())
                .resumeId(resume.getResumeId())
                .resume(blob)
                .status(resume.getResumeStatus())
                .build();

    }

}
