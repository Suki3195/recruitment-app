package com.recruitment.app.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobRequest {

    private Blob jd;
    private String jdShortName;
    private String jdDescription;
    private String skill;
    private String subSkill;


}
