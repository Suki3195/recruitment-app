package com.recruitment.app.mapper;

import com.recruitment.app.entity.UserManagement;
import com.recruitment.app.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserManagement getUserManagementFromUSerRequest (UserRequest request) {
            return UserManagement.builder()
                    .emailId(request.getEmailId())
                    .role(request.getRole())
                    .userName(request.getUserName())
                    .managerEmailId(request.getManagerEmailId())
                    .region(request.getRegion())
                    .dmMailId(request.getDmMailId())
                    .clients(request.getClients())
                    .build();

    }


    public UserRequest getUserResponseFromDb (UserManagement  userFromDb){
        return UserRequest.builder()
                .userName(userFromDb.getUserName())
                .emailId(userFromDb.getEmailId())
                .role(userFromDb.getRole())
                .clients(userFromDb.getClients())
                .dmMailId(userFromDb.getDmMailId())
                .managerEmailId(userFromDb.getManagerEmailId())
                .region(userFromDb.getRegion())
//                .id(userFromDb.getUserId().toString())
                .build();


    }

}
