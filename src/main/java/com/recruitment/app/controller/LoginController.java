package com.recruitment.app.controller;

import com.recruitment.app.request.LoginRequest;
import com.recruitment.app.request.ResetPasswordRequest;
import com.recruitment.app.request.UserRequest;
import com.recruitment.app.service.impl.LogInServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path="/login")
public class LoginController {

    @Autowired
    private LogInServiceImpl logInService;

    @PostMapping("/userLogin")
    @CrossOrigin(origins = { "*" })
    public String login (@RequestBody LoginRequest request){

        log.info("LOGGING USER");
       String result =logInService.loginUser(request);
        log.info(result);
      return result;

    }


    @PostMapping("/resetPassword")
    @CrossOrigin(origins = { "*" })
    public String resetPassword (@RequestBody ResetPasswordRequest request){

        return logInService.resetPassword(request);

    }

}
