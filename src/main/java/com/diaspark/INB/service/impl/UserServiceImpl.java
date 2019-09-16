package com.diaspark.INB.service.impl;

import com.diaspark.INB.DTO.LoginUserDTO;
import com.diaspark.INB.DTO.RegisterUserDTO;
import com.diaspark.INB.DTO.UserAccountDto;
import com.diaspark.INB.DTO.UserResponseDTO;
import com.diaspark.INB.config.JwtTokenProvider;
import com.diaspark.INB.entity.User;
import com.diaspark.INB.entity.UserAccount;
import com.diaspark.INB.entity.UserPrincipal;
import com.diaspark.INB.exception.ForbiddenException;
import com.diaspark.INB.exception.NotFoundException;
import com.diaspark.INB.repository.UserAccountRepository;
import com.diaspark.INB.repository.UserRepository;
import com.diaspark.INB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    HttpServletResponse httpServletResponse;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;


    @Override
    public void registerUser(RegisterUserDTO registerUserDTO) {
        User newUser = createRegisterUser(registerUserDTO);
        User saveuser = userRepository.save(newUser);
        UserAccount userAccount = createAccount(registerUserDTO, saveuser);
        userAccountRepository.save(userAccount);
    }

    /*
     * This function is transformation on input dto to registerUser enity bean
     */
    private User createRegisterUser(RegisterUserDTO registerUserDTO) {
        User newUser = new User();
        newUser.setPassword(registerUserDTO.getPassword());
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
    public UserResponseDTO authenticateUser(LoginUserDTO loginUserDTO) throws Exception {
        User existingUser = userRepository.findUserByUsername(loginUserDTO.getUsername());
        if (existingUser == null || !existingUser.getPassword().equals(loginUserDTO.getPassword())) {
            throw new ForbiddenException("username or password is incorrect");
        }

        //creating UserPrincipal object to set in token
        UserPrincipal userPrincipal = buildUserPrincipal(existingUser);

        //Generating JWT token
        String token = jwtTokenProvider.generateToken(userPrincipal);

        //building UserResponse Dto to send json back to client
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setFirstName(existingUser.getFirstName());
        userResponseDTO.setLastName(existingUser.getLastName());
        userResponseDTO.setCity(existingUser.getCity());
        userResponseDTO.setEmail(existingUser.getEmail());
        userResponseDTO.setToken(token);

        //adding token to cookie
        httpServletResponse.addCookie(buildCookies("X-AUTH-TOKEN", token));

        return userResponseDTO;
    }

    private UserPrincipal buildUserPrincipal(User user) throws Exception {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setId(user.getCustomerId());
        userPrincipal.setEmailId(user.getEmail());
        userPrincipal.setUsername(user.getUsername());
        userPrincipal.setNow(now);
        userPrincipal.setExpireAt(expiryDate);
        return userPrincipal;

    }

    private Cookie buildCookies(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(1600);
        cookie.setHttpOnly(true);
        return cookie;
    }

    private UserAccount createAccount(RegisterUserDTO registerUserDto, User user) {
        UserAccount userAccount = new UserAccount();
        userAccount.setAccountBalance(0);
        userAccount.setAccountType(registerUserDto.getAccountType());
        userAccount.setUser(user);
        return userAccount;
    }

    @Override
    public void saveAccount(UserAccountDto userAccountDto) {
        User user = userRepository.findUserById(userAccountDto.getCustomerId());
        if (user == null) {
            throw new NotFoundException("Customer Id is invalid");
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setAccountBalance(0);
        userAccount.setAccountType(userAccountDto.getAccountType());
        userAccount.setUser(user);
        userAccountRepository.save(userAccount);
    }
}
