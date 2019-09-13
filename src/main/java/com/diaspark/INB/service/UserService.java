package com.diaspark.INB.service;

import com.diaspark.INB.DTO.LoginUserDTO;
import com.diaspark.INB.DTO.RegisterUserDTO;

public interface UserService {
    void registerUser(RegisterUserDTO registerUserDTO);
    String authenticateUser(LoginUserDTO loginUserDTO);
}
