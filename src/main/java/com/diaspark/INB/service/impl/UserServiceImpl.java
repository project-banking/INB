package com.diaspark.INB.service.impl;

import com.diaspark.INB.DTO.LoginUserDTO;
import com.diaspark.INB.DTO.RegisterUserDTO;
import com.diaspark.INB.entity.User;
import com.diaspark.INB.repository.UserRepository;
import com.diaspark.INB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(RegisterUserDTO registerUserDTO) {
        User newUser = createRegisterUser(registerUserDTO);
        userRepository.save(newUser);
        
    }

    /*
      This function is transformation on input dto to registerUser enity bean
     */
    private User createRegisterUser(RegisterUserDTO registerUserDTO) {
        User newUser = new User();
        newUser.setPassword(registerUserDTO.getPassword());
       // newUser.setUsername(UUID.randomUUID().toString());
        newUser.setFirstName(registerUserDTO.getFirstName());
        newUser.setLastName(registerUserDTO.getLastName());
        newUser.setAccountType(registerUserDTO.getAccountType());
        newUser.setAddressLine1(registerUserDTO.getAddressLine1());
        newUser.setAddressLine2(registerUserDTO.getAddressLine2());
        newUser.setAddressLine3(registerUserDTO.getAddressLine3());
        newUser.setCell(registerUserDTO.getMobile());
        newUser.setEmail(registerUserDTO.getEmail());
        newUser.setState(registerUserDTO.getState());
        newUser.setZip(registerUserDTO.getZip());
        newUser.setCity(registerUserDTO.getCity());
        newUser.setPhone(registerUserDTO.getPhone());
        newUser.setUsername(registerUserDTO.getUsername());
        
        return newUser;
    }

    @Override
    public String authenticateUser(LoginUserDTO loginUserDTO){
        User existingUser = userRepository.findUserByUsername(loginUserDTO.getUsername());
        if(existingUser == null || !existingUser.getPassword().equals(loginUserDTO.getPassword())){
            return "Authentication Failed";
        }
        return "Authentication passed";
    }
}
