package com.diaspark.INB.service.impl;

import com.diaspark.INB.DTO.AccountResponseDTO;
import com.diaspark.INB.DTO.UserAccountDto;
import com.diaspark.INB.entity.AccountType;
import com.diaspark.INB.entity.User;
import com.diaspark.INB.entity.UserAccount;
import com.diaspark.INB.exception.NotFoundException;
import com.diaspark.INB.mapper.EntityToDTOMapper;
import com.diaspark.INB.repository.UserAccountRepository;
import com.diaspark.INB.repository.UserRepository;
import com.diaspark.INB.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private EntityToDTOMapper entityToDTOMapper;

    @Override
    public AccountResponseDTO saveAccount(UserAccountDto userAccountDto) {
        AccountType.findAccountByCode(String.valueOf(userAccountDto.getAccountType()));
        User user = userRepository.findUserById(userAccountDto.getCustomerId());
        if (user == null) {
            throw new NotFoundException("Customer Id is invalid");
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setAccountBalance(0);
        userAccount.setAccountType(userAccountDto.getAccountType());
        userAccount.setUser(user);
        UserAccount savedUserAccount = userAccountRepository.save(userAccount);
        return entityToDTOMapper.buildAccountResponseDto(savedUserAccount);
    }
}
