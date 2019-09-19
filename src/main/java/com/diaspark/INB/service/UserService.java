package com.diaspark.INB.service;

import com.diaspark.INB.DTO.*;
import com.diaspark.INB.entity.UserAccount;
import com.diaspark.INB.entity.UserTransaction;

import java.util.List;


public interface UserService {
    void registerUser(RegisterUserDTO registerUserDTO);

    UserResponseDTO authenticateUser(LoginUserDTO loginUserDTO) throws Exception;

    void saveAccount(UserAccountDto userAccountDto);

    EmailResponseDTO sendQuery(SendMailDTO sendMailDTO);

    List<UserResponseDTO> retreiveUsersName(String status);

    UserResponseDTO updateUserStatus(long customerId, String status);

    public void requestMoney(TransactionDTO userTransaction);
    
	//public UserTransaction proceedTransaction(String transType);
}
