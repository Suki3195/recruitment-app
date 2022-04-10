package com.recruitment.app.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;
    private String emailId;
    private String userRole;
    private String dmEmailId;
    private String region;
    private String customer;
    private String managerEmailId;


}
