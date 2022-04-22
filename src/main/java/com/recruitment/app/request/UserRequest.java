package com.recruitment.app.request;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String userName;
    private String emailId;
    private String role;
    private String dmMailId;
    private String region;
    private String clients;
    private String managerEmailId;

}
