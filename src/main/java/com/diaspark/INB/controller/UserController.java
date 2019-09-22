package com.diaspark.INB.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diaspark.INB.DTO.EmailResponseDTO;
import com.diaspark.INB.DTO.LoginUserDTO;
import com.diaspark.INB.DTO.RegisterUserDTO;
import com.diaspark.INB.DTO.SendMailDTO;
import com.diaspark.INB.DTO.TransactionDTO;
import com.diaspark.INB.DTO.TransactionResponseDTO;
import com.diaspark.INB.DTO.UserAccountDto;
import com.diaspark.INB.DTO.UserResponseDTO;
import com.diaspark.INB.service.UserService;


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
    @GetMapping("/fetch/addMoney")
    public List<TransactionResponseDTO> retrievePendingTransactions(@RequestParam String status){
    	return userService.retrievePendingTransactions(status);
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
    @PutMapping("/update/transactionstatus/{status}")
    public void updateTransactionStatus(@PathVariable("status") String status) {
    	userService.updateTransactionStatus(status);
    }
    
}

