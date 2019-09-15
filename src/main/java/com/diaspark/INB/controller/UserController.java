package com.diaspark.INB.controller;

import com.diaspark.INB.DTO.LoginUserDTO;
import com.diaspark.INB.DTO.RegisterUserDTO;
import com.diaspark.INB.DTO.UserAccountDto;
import com.diaspark.INB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public void registration(@RequestBody RegisterUserDTO registerUserDTO) {
         userService.registerUser(registerUserDTO);
    }

    @PostMapping("/login")
    public String authenticate(@RequestBody LoginUserDTO loginUserDTO) {
        return userService.authenticateUser(loginUserDTO);
    }
    
    @PostMapping("/account")
    public void account(@RequestBody UserAccountDto userAccountDto) {
    	 userService.saveAccount(userAccountDto);
    }
}
