package com.recruitment.app.service.impl;

import com.recruitment.app.request.UserRequest;

import javax.transaction.Transactional;

public interface IUserManagementService {
    @Transactional
    String saveUserAndSendMail (UserRequest request);
}
