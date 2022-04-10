package com.recruitment.app.service.impl;


import com.recruitment.app.service.PasswordGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;


@Slf4j
@Service
public class PasswordGeneratorServiceImpl implements PasswordGeneratorService {

    public String generatePassword() {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[10];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        StringBuilder pw = new StringBuilder();
        for(int i = 4; i< 10 ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }

        for(char a : password) {
           pw.append(a);
        }
        log.info("THE PASSWORD GENERATED IS  :- " + pw);
        return pw.toString();
    }



}
