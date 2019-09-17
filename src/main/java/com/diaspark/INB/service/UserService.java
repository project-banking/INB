package com.diaspark.INB.service;

import java.util.List;

import com.diaspark.INB.DTO.ContactUsDTO;
import com.diaspark.INB.DTO.EmailResponseDTO;
import com.diaspark.INB.DTO.LoginUserDTO;
import com.diaspark.INB.DTO.RegisterUserDTO;
import com.diaspark.INB.DTO.UserAccountDto;
import com.diaspark.INB.DTO.UserResponseDTO;
import com.diaspark.INB.entity.User;


public interface UserService {
    void registerUser(RegisterUserDTO registerUserDTO);
    UserResponseDTO authenticateUser(LoginUserDTO loginUserDTO) throws Exception;
   // UserAccount createAccount(UserAccountDto userAccountDto);
	public void saveAccount(UserAccountDto userAccountDto);
	public EmailResponseDTO send(ContactUsDTO contactUsDTO);
	public List<String> retreiveUsersName(); 
	     
	
	
	


    
}
