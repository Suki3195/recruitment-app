package com.recruitment.app.service.impl;

import com.recruitment.app.entity.UserManagement;
import com.recruitment.app.mapper.UserMapper;
import com.recruitment.app.repository.UserManagementRepository;
import com.recruitment.app.request.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        UserManagement userInDb = userRepository.findByEmailIdAndUserRole(request.getEmailId(),request.getRole());
        List<UserManagement> userinDbWithDiffRole = userRepository.findByEmailId(request.getEmailId());

        log.info ("USER ALREADY IN DB " + userInDb);

        if(userInDb!=null){
            result="USER_ALREADY_EXISTS";
        }

        if (userInDb == null &&
                (!userinDbWithDiffRole.isEmpty())) {

            log.info("User with different roles");
            log.info("WITH SAME ROLE " + userInDb);
            log.info("WITH DIFFERENT ROLE" + userinDbWithDiffRole);
            for (UserManagement user : userinDbWithDiffRole){
                log.info("UPDATING PASSWORD FOR EXISTING USERS");
                user.setPassword(pw);
                user.setIsFirstLogin("Y");
                userRepository.save(user);
            }

            addUserWithNewRole(request,pw);
            result="USER_ADDED";
        }

        else if ((userInDb == null && userinDbWithDiffRole.isEmpty()) ){
            log.info("NEW USER TO BE ADDED");
            result= addUserWithNewRole(request,pw);
        }

        return result;
    }

    public List<UserRequest> getAllUser () {

        List<UserManagement> usersInDb = (List<UserManagement>) userRepository.findAll();
        List<UserRequest> userResponses = new ArrayList<>();
        for (UserManagement user : usersInDb){
            UserRequest userResponse = userMapper.getUserResponseFromDb(user);
            userResponses.add(userResponse);
        }
        return userResponses;

    }

    public UserRequest getUserById(Integer id){

        Optional<UserManagement> userFromDbOptional = userRepository.findById(id);
        UserManagement userFromDb = userFromDbOptional.get();
        return userMapper.getUserResponseFromDb(userFromDb);

    }

    public void deleteUserFromDb(Integer id){
//        UserManagement user = userRepository.findByEmailIdAndRole(emailId,role);
        userRepository.deleteById(id);


    }

    public void updateUser (Integer id , UserRequest request){
        Optional<UserManagement> optionalUserFromDb = userRepository.findById(id);
        UserManagement userFromDb = optionalUserFromDb.get();
        userFromDb.setUserName(request.getUserName());
        userFromDb.setUserRole(request.getRole());
        userFromDb.setDmMailId(request.getDmMailId());
        userFromDb.setManagerMailId(request.getManagerEmailId());
        userFromDb.setRegion(request.getRegion());
        userFromDb.setClients(request.getClients());
        userFromDb.setContactNumber(request.getTelNo());

        userRepository.save(userFromDb);

    }

    private String addUserWithNewRole(UserRequest request,String pw){
        UserManagement user = userMapper.getUserManagementFromUSerRequest(request);
        user.setPassword(pw);
        user.setIsFirstLogin("Y");
        log.info("ADDING USER WITH NEW ROLE");
        userRepository.save(user);
        emailSenderService.sendMail(request.getEmailId(), pw);
        return "USER_ADDED";
    }
}
