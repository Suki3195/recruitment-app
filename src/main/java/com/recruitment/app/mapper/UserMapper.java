package com.recruitment.app.mapper;

import com.recruitment.app.entity.UserManagement;
import com.recruitment.app.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserManagement getUserManagementFromUSerRequest (UserRequest request) {
            return UserManagement.builder()
                    .emailId(request.getEmailId())
                    .userRole(request.getRole())
                    .userName(request.getUserName())
                    .managerMailId(request.getManagerEmailId())
                    .region(request.getRegion())
                    .dmMailId(request.getDmMailId())
                    .clients(request.getClients())
                    .contactNumber(request.getTelNo())
                    .build();

    }


    public UserRequest getUserResponseFromDb (UserManagement  userFromDb){
        return UserRequest.builder()
                .userName(userFromDb.getUserName())
                .userId(userFromDb.getUserId())
                .emailId(userFromDb.getEmailId())
                .role(userFromDb.getUserRole())
                .clients(userFromDb.getClients())
                .dmMailId(userFromDb.getDmMailId())
                .managerEmailId(userFromDb.getManagerMailId())
                .region(userFromDb.getRegion())
                .telNo(userFromDb.getContactNumber())
                .build();


    }

}
