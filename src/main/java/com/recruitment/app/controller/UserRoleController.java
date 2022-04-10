package com.recruitment.app.controller;

import com.recruitment.app.request.UserRequest;
import com.recruitment.app.service.impl.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserRoleController {



    @Autowired
    private UserManagementService userService;


    @PostMapping("/addUserAndSendMail")
    public String addUserRole (@RequestBody UserRequest request){

        return userService.saveUserAndSendMail(request);

    }

    @PostMapping("/getUser")
    public String getUser (){

        return "Add user!!";

    }





}
