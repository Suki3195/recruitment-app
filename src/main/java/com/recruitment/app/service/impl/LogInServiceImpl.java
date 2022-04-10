package com.recruitment.app.service.impl;


import com.recruitment.app.entity.UserManagement;
import com.recruitment.app.repository.UserManagementRepository;
import com.recruitment.app.request.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LogInServiceImpl {

    @Autowired
    private UserManagementRepository userRepository;

    public String loginUser(LoginRequest request){
        String loginStatus = null;
        List<UserManagement> userList = userRepository.findByEmailId(request.getEmailId());

       for (UserManagement user : userList) {

           if (request.getPassword().equals(user.getPassword())) {
               if (user.getIsFirstLogIn().equals("Y")) {
                   loginStatus = "RESET_PASSWORD";
               } else {
                   loginStatus = "LOGIN_SUCCESS";

               }
           } else {
               loginStatus = "INVALID_PASSWORD";
           }
       }
        return loginStatus;

    }


    public String resetPassword (String email, String newPassword){
       List< UserManagement> useList = userRepository.findByEmailId(email);
       for (UserManagement user : useList){
           user.setPassword(newPassword);
           user.setIsFirstLogIn("N");
       }

        return null;
    }
}
