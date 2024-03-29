package com.recruitment.app.service.impl;


import com.recruitment.app.entity.UserManagement;
import com.recruitment.app.repository.UserManagementRepository;
import com.recruitment.app.request.LoginRequest;
import com.recruitment.app.request.ResetPasswordRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LogInServiceImpl {

    @Autowired
    private UserManagementRepository userRepository;

    public String loginUser(LoginRequest request){
        log.info("**************" + request.getEmailId()  + "      " + request.getPassword());
        String loginStatus = null;
        List<UserManagement> userList = userRepository.findByEmailId(request.getEmailId());
        if(!userList.isEmpty()){
            UserManagement user = userList.get(0);
            if (request.getPassword().equals(user.getPassword())) {
                if (user.getIsFirstLogin().equals("Y")) {
                    loginStatus = "RESET_PASSWORD";
                } else {
                    loginStatus = "LOGIN_SUCCESS";

                }
            } else {
                loginStatus = "INVALID_PASSWORD";
            }
        }
        else {
            loginStatus="LOGIN_FAIL";
        }

        return loginStatus;

    }


    public String resetPassword (ResetPasswordRequest request){
       List< UserManagement> useList = userRepository.findByEmailId(request.getEmailId());
       for (UserManagement user : useList){
           user.setPassword(request.getNewPassword());
           user.setIsFirstLogin("N");
           userRepository.save(user);
       }

        return "PASSWORD_RESET_SUCCESSFUL";
    }
}
