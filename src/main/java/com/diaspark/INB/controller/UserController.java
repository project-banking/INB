package com.diaspark.INB.controller;

import com.diaspark.INB.DTO.*;
import com.diaspark.INB.entity.UserAccount;
import com.diaspark.INB.entity.UserTransaction;
import com.diaspark.INB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public UserResponseDTO authenticate(@RequestBody LoginUserDTO loginUserDTO) throws Exception {
        return userService.authenticateUser(loginUserDTO);
    }

    @PostMapping("/account")
    public void account(@RequestBody UserAccountDto userAccountDto) {
        userService.saveAccount(userAccountDto);
    }

    @PostMapping("/contact-us")
    public EmailResponseDTO send(@RequestBody SendMailDTO sendMailDTO) {
        return userService.sendQuery(sendMailDTO);
    }
    //user request add money
    
    @PostMapping("/requestMoney")
    public void request(@RequestBody TransactionDTO userTransaction) throws Exception {
    	 userService.requestMoney(userTransaction);
    }

    /*
     * usage : http://localhost:8080/user/fetch?status=rejected
     */
    @GetMapping("/fetch")
    public List<UserResponseDTO> retrieveUsersName(@RequestParam String status) {
        return userService.retreiveUsersName(status);
    }

    /*
     * http://localhost:8080/user/update/status/1?status=approved
     */
    @PutMapping("/update/status/{customerId}")
    public UserResponseDTO updateUserStatus(@PathVariable long customerId, @RequestParam String status) {
         return userService.updateUserStatus(customerId, status);
	
    }
    /*@PutMapping("/addmoney/{accountNo}")
    public TransactionDTO updateMoney(@PathVariable long accountNo,@RequestParam String money) {
    	return   
    }*/
}

