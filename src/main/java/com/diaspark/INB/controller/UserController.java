package com.diaspark.INB.controller;

import com.diaspark.INB.DTO.ContactUsDTO;
import com.diaspark.INB.DTO.EmailResponseDTO;
import com.diaspark.INB.DTO.LoginUserDTO;
import com.diaspark.INB.DTO.RegisterUserDTO;
import com.diaspark.INB.DTO.UserAccountDto;
import com.diaspark.INB.DTO.UserResponseDTO;
import com.diaspark.INB.entity.User;
import com.diaspark.INB.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    /*@Autowired
	private MailService notificationService;
*/

    @PostMapping("/registration")
    public void registration(@RequestBody RegisterUserDTO registerUserDTO) {
         userService.registerUser(registerUserDTO);
    }

    @PostMapping("/login")
    public UserResponseDTO authenticate(@RequestBody LoginUserDTO loginUserDTO) throws Exception{
        return userService.authenticateUser(loginUserDTO);
    }
    
    @PostMapping("/account")
    public void account(@RequestBody UserAccountDto userAccountDto) {
    	 userService.saveAccount(userAccountDto);
    }
    @PostMapping("/Contact-Us")
    public EmailResponseDTO send(@RequestBody ContactUsDTO contactUsDTO) {
    	return userService.send(contactUsDTO);
    		
    }
    @GetMapping("/getAllUserName")
   
    	public List<String>retrieveUsersName()
    	{ 
    		return userService.retreiveUsersName();
    	}
    }

