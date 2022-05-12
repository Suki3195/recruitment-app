package com.recruitment.app.response;


import lombok.*;

import java.sql.Blob;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobResponse {

    private Blob jd;
    private String jdShortName;
    private  String jdDescription;
    private String skill;
    private String subSkills;
    private String ocrId;

}
