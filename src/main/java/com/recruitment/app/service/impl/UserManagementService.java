package com.recruitment.app.service.impl;


import com.recruitment.app.entity.UserManagement;
import com.recruitment.app.mapper.UserMapper;
import com.recruitment.app.repository.UserManagementRepository;
import com.recruitment.app.request.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class UserManagementService  implements IUserManagementService {

    @Autowired
    private UserManagementRepository userRepository;

    @Autowired PasswordGeneratorServiceImpl generatorService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmailSenderServiceImpl emailSenderService;


    @Override
    @Transactional
    public String saveUserAndSendMail (UserRequest request){

        String pw=generatorService.generatePassword();
        String result = null;
        List<UserManagement> userinDb = userRepository.findByEmailIdAndUserRole(request.getEmailId(),request.getUserRole());
        List<UserManagement> userinDbWithDiffRole = userRepository.findByEmailId(request.getEmailId());

        if (( userinDb.isEmpty()) &&
                (!userinDbWithDiffRole.isEmpty())) {

            log.info("User with different roles");
            log.info("WITH SAME ROLE " + userinDb.toString());
            log.info("WITH DIFFERENT ROLE" + userinDbWithDiffRole.toString());
            for (UserManagement user : userinDbWithDiffRole){
                user.setPassword(pw);
                user.setIsFirstLogIn("Y");
                userRepository.save(user);
            }

            addUserWithNewRole(request,pw);
//            emailSenderService.sendMail(pw);
            result="USER_ADDED";
        }

        else if ((userinDb == null || userinDb.isEmpty()) &&
                (userinDbWithDiffRole == null || userinDbWithDiffRole.isEmpty()) ){
            log.info("NEW USER TO BE ADDED");
            result= addUserWithNewRole(request,pw);
        }


        else{
            result="USER_ALREADY_EXISTS";
        }

        return result;
    }



    private String addUserWithNewRole(UserRequest request,String pw){
        UserManagement user = userMapper.getUserManagementFromUSerRequest(request);
        user.setPassword(pw);
        user.setIsFirstLogIn("Y");
        userRepository.save(user);
//        emailSenderService.sendMail(pw);
        return "USER_ADDED";
    }
}
