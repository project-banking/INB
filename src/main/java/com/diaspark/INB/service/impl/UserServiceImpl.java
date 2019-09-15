package com.diaspark.INB.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diaspark.INB.DTO.LoginUserDTO;
import com.diaspark.INB.DTO.RegisterUserDTO;
import com.diaspark.INB.DTO.UserAccountDto;
import com.diaspark.INB.entity.User;
import com.diaspark.INB.entity.UserAccount;
import com.diaspark.INB.repository.UserAccountRepository;
import com.diaspark.INB.repository.UserRepository;
import com.diaspark.INB.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserAccountRepository userAccountRepository;

	@Override
	public void registerUser(RegisterUserDTO registerUserDTO) {
		User newUser = createRegisterUser(registerUserDTO);

		User saveuser=userRepository.save(newUser);
		UserAccount userAccount=createAccount(registerUserDTO, saveuser);
		userAccountRepository.save(userAccount);

	}

	/*
	 * This function is transformation on input dto to registerUser enity bean
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
	public String authenticateUser(LoginUserDTO loginUserDTO) {
		User existingUser = userRepository.findUserByUsername(loginUserDTO.getUsername());
		if (existingUser == null || !existingUser.getPassword().equals(loginUserDTO.getPassword())) {
			return "Authentication Failed";
		}
		return "Authentication passed";
	}

	public UserAccount createAccount(RegisterUserDTO registerUserDto,User user) {
		UserAccount userAccount = new UserAccount();
		// userAccount.setId(userAccountDto.getId());
		userAccount.setAccountBalance(0);
		userAccount.setAccountType(registerUserDto.getAccountType());
		userAccount.setUser(user);
		
		return userAccount;

	}

	@Override
	public void saveAccount(UserAccountDto userAccountDto) {
		User user=userRepository.findUserById(userAccountDto.getCustomerId());
		UserAccount userAccount=new UserAccount();
				userAccount.setAccountBalance(0);
				userAccount.setAccountType(userAccountDto.getAccountType());
				userAccount.setUser(user);
				userAccountRepository.save(userAccount);
				
		

	}
}
