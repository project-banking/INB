package com.diaspark.INB.service;

import java.util.List;

import com.diaspark.INB.DTO.EmailResponseDTO;
import com.diaspark.INB.DTO.LoginUserDTO;
import com.diaspark.INB.DTO.RegisterUserDTO;
import com.diaspark.INB.DTO.SendMailDTO;
import com.diaspark.INB.DTO.TransactionDTO;
import com.diaspark.INB.DTO.UserAccountDto;
import com.diaspark.INB.DTO.UserResponseDTO;


public interface UserService {
    void registerUser(RegisterUserDTO registerUserDTO);

    UserResponseDTO authenticateUser(LoginUserDTO loginUserDTO) throws Exception;

    void saveAccount(UserAccountDto userAccountDto);

    EmailResponseDTO sendQuery(SendMailDTO sendMailDTO);

    List<UserResponseDTO> retreiveUsersName(String status);

    UserResponseDTO updateUserStatus(long customerId, String status);

     void requestMoney(TransactionDTO userTransaction);

	void updateTransactionStatus(String status);
	
    
	//public UserTransaction proceedTransaction(String transType);
}
