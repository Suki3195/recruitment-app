package com.recruitment.app.controller;

import com.recruitment.app.request.LoginRequest;
import com.recruitment.app.request.UserRequest;
import com.recruitment.app.service.impl.LogInServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/login")
public class LoginController {

    @Autowired
    private LogInServiceImpl logInService;

    @PostMapping("/userLogin")
    @CrossOrigin(origins = { "*" })
    public String login (@RequestBody LoginRequest request){

      return logInService.loginUser(request);

    }


    @GetMapping("/resetPassword")
    @CrossOrigin(origins = { "*" })
    public String resetPassword (@PathVariable String emailId,@PathVariable String newPassword){

        return logInService.resetPassword(emailId,newPassword);

    }

}
