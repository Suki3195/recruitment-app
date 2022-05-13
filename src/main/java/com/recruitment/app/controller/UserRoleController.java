package com.recruitment.app.controller;

import com.recruitment.app.request.UserRequest;
import com.recruitment.app.service.impl.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path="/user")
public class UserRoleController {



    @Autowired
    private UserManagementService userService;


    @PostMapping("/addUserAndSendMail")
    public String addUserRole (@RequestBody UserRequest request){

        return userService.saveUserAndSendMail(request);

    }

    @GetMapping("/getAllUsers")
    public List<UserRequest> getAllUser (){

        return userService.getAllUser();

    }


    @GetMapping("/getUserById")
    public UserRequest getAllUser (@RequestParam Integer id){

        return userService.getUserById(id);

    }


    @PatchMapping("/updateUser")
    public void updateUser (@RequestParam Integer id, @RequestBody UserRequest request){
        log.info("USER UPDATED SUCCESSFULLY");
         userService.updateUser(id,request);

    }


    @DeleteMapping("/deleteUser")
    public String deleteUserFromDb (@RequestParam Integer id){

         userService.deleteUserFromDb(id);
         return "DELETED_SUCCESSFULLY";

    }


}
