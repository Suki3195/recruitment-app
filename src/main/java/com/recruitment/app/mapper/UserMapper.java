package com.recruitment.app.mapper;

import com.recruitment.app.entity.UserManagement;
import com.recruitment.app.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserManagement getUserManagementFromUSerRequest (UserRequest request) {
            return UserManagement.builder()
                    .emailId(request.getEmailId())
                    .userRole(request.getUserRole())
                    .userName(request.getName())
                    .managerEmailId(request.getManagerEmailId())
                    .region(request.getRegion())
                    .dmMailId(request.getDmEmailId())
                    .customers(request.getCustomer())
                    .build();



    }


}
