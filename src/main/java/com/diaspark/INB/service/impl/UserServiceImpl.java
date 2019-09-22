package com.diaspark.INB.service.impl;

import com.diaspark.INB.DTO.*;
import com.diaspark.INB.config.JwtTokenProvider;
import com.diaspark.INB.entity.TransactionType;
import com.diaspark.INB.entity.User;
import com.diaspark.INB.entity.UserAccount;
import com.diaspark.INB.entity.UserPrincipal;
import com.diaspark.INB.entity.UserStatus;
import com.diaspark.INB.entity.UserTransaction;
import com.diaspark.INB.exception.EmailSendException;
import com.diaspark.INB.exception.ForbiddenException;
import com.diaspark.INB.exception.NotFoundException;
import com.diaspark.INB.repository.UserAccountRepository;
import com.diaspark.INB.repository.UserRepository;
import com.diaspark.INB.repository.UserTransactionRepository;
import com.diaspark.INB.service.ContactUsMailService;
import com.diaspark.INB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserAccountRepository userAccountRepository;
	@Autowired
	private UserTransactionRepository userTransactionRepository;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	HttpServletResponse httpServletResponse;

	@Autowired
	private ContactUsMailService notificationService;

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
		newUser.setStatus(UserStatus.PENDING.getStatus());
		return newUser;
	}

	public void requestMoney(TransactionDTO userTransaction) {
		proceedTransaction(userTransaction);
	}

	@Override
	public UserResponseDTO authenticateUser(LoginUserDTO loginUserDTO) throws Exception {
		User existingUser = userRepository.findUserByUsername(loginUserDTO.getUsername());
		if (existingUser == null || (!existingUser.getPassword().equals(loginUserDTO.getPassword())
				&& !UserStatus.APPROVED.getStatus().equals(existingUser.getStatus()))) {
			throw new ForbiddenException("username or password is incorrect");
		}

		// creating UserPrincipal object to set in token
		UserPrincipal userPrincipal = buildUserPrincipal(existingUser);

		// Generating JWT token
		String token = jwtTokenProvider.generateToken(userPrincipal);
List<AccountResponseDTO> accountResponses= new ArrayList<>();
List<UserAccount> userAccountList = userAccountRepository.findUserAccountByUser(existingUser);
		for(UserAccount userAccount: userAccountList ) {
			AccountResponseDTO accountResponseDTO= new AccountResponseDTO();
			accountResponseDTO.setBalance(userAccount.getAccountBalance());
			accountResponseDTO.setAccountType(userAccount.getAccountType());
			accountResponseDTO.setAccountNumber(userAccount.getAccountNumber());
			accountResponses.add(accountResponseDTO);
			}
		
		// building UserResponse Dto to sendQuery json back to client
		UserResponseDTO userResponseDTO = buildUserResponseDTO(existingUser);
		userResponseDTO.setToken(token);
		userResponseDTO.setAccountResponseDTO(accountResponses);
		// adding token to cookie
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

	public EmailResponseDTO sendQuery(SendMailDTO sendMailDTO) {
		/*
		 * Creating a User with the help of User class that we have declared and setting
		 * Email address of the sender.
		 */
		sendMailDTO.setToAddress("IndianNetBank3A@gmail.com"); // Receiver's email address
		sendMailDTO.setSubject(sendMailDTO.getFirstName() + " " + sendMailDTO.getLastName() + " has following query");
		/*
		 * Here we will call sendEmail() for Sending mail to the sender.
		 */
		EmailResponseDTO emailResponseDTO = new EmailResponseDTO();
		try {
			notificationService.sendEmail(sendMailDTO);
			emailResponseDTO.setContactUsResponse("Email sent Succesfully");
		} catch (MailException mailException) {
			throw new EmailSendException("Failed to send email");
		}
		
		return emailResponseDTO;

	}

	@Override
	public List<UserResponseDTO> retreiveUsersName(String status) {

		// Validate if incoming status is a valid status
		UserStatus.findCodeByStatus(status);
		List<UserResponseDTO> userNames = new ArrayList<>();

		// Search users by status
		List<User> userList = userRepository.findUserByStatus(status);
		for (User user : userList) { // for each loop/ how to use this in java 8
			UserResponseDTO userResponseDTO = buildUserResponseDTO(user);
			userNames.add(userResponseDTO);
		}
		return userNames;

	}
	@Override
	public List<TransactionResponseDTO> retrievePendingTransactions(String status) {
		UserStatus.findCodeByStatus(status);
		List<TransactionResponseDTO> requestMoneyUsers=new ArrayList<>();
		List<UserTransaction> requestList=userTransactionRepository.findUserTransactionByStatus(status);
		
		for (UserTransaction userTransaction : requestList) {
			TransactionResponseDTO transactionResponseDTO=buildTransactionResponseDTO(userTransaction);
			requestMoneyUsers.add(transactionResponseDTO);
		}
		
        return requestMoneyUsers;
	}

	@Override
	public UserResponseDTO updateUserStatus(long customerId, String status) {
		// Validate if incoming status is a valid status
		UserStatus.findCodeByStatus(status);

		// Find existingUser which need to be updated
		User existingUser = userRepository.findUserById(customerId);
		if (existingUser == null) {
			throw new NotFoundException("Customer Id is invalid");
		}
		existingUser.setStatus(status);
		// update user with new status
		User savedUser = userRepository.save(existingUser);
		sendMailIfApproved(savedUser);
		sendMailIfRejected(savedUser);
		return buildUserResponseDTO(savedUser);
	}

	public UserTransaction proceedTransaction(TransactionDTO userTransaction) {
		long sourceAccountNo = userTransaction.getSourceAccount();
		long targetAccountNo = userTransaction.getTargetAccount();
		UserAccount sourceAccount = userAccountRepository.findByAccountNumber(sourceAccountNo);
		UserAccount targetAccount = userAccountRepository.findByAccountNumber(targetAccountNo);
		// UserAccountDto userAccountDto=new UserAccountDto();
		UserTransaction userTransactionn = new UserTransaction();
		TransactionType.findCodeByTransType(userTransaction.getTransType());

		// long sourceAccountNo= userTransaction.getSourceAccount();
		// double amount=transactionDTO.getAmount();
		// long targetAccountNo=userTransaction.getTargetAccount();

		// userAccountDto.getAccountBalance();
		if (sourceAccountNo == targetAccountNo) {
			userTransactionn.setStatus(UserStatus.PENDING.getStatus());
		} else {
			userTransactionn.setStatus(UserStatus.APPROVED.getStatus());
		}

		userTransactionn.setAmount(userTransaction.getAmount());
		userTransactionn.setDate(userTransaction.getDate());
		// Retreive User Account by account Number
		userTransactionn.setSourceAccount(userAccountRepository.findByAccountNumber(sourceAccountNo));
		userTransactionn.setTargetAccount(userAccountRepository.findByAccountNumber(targetAccountNo));
		userTransactionn.setTransType(userTransaction.getTransType());
		userTransactionRepository.save(userTransactionn);

		if (sourceAccountNo != targetAccountNo && sourceAccount.getAccountBalance() >= userTransactionn.getAmount()) {
			
	sourceAccount.setAccountBalance(sourceAccount.getAccountBalance() - userTransactionn.getAmount());

		}
	
		targetAccount.setAccountBalance(targetAccount.getAccountBalance() + userTransactionn.getAmount());

		// userTransactionRepository.save(userAccount);
		userAccountRepository.save(sourceAccount);
		userAccountRepository.save(targetAccount);

		return userTransactionRepository.save(userTransactionn);
	}
	private TransactionResponseDTO buildTransactionResponseDTO(UserTransaction userTransaction) {
		TransactionResponseDTO transactionResponseDTO=new TransactionResponseDTO();
		transactionResponseDTO.setAmount(userTransaction.getAmount());
		transactionResponseDTO.setSourceAccount(userTransaction.getSourceAccount());
		transactionResponseDTO.setTransId(userTransaction.getTransId());
		transactionResponseDTO.setStatus(userTransaction.getStatus());
		transactionResponseDTO.setTargetAccount(userTransaction.getTargetAccount());
		transactionResponseDTO.setDate(userTransaction.getDate());
		transactionResponseDTO.setTransId(userTransaction.getTransId());
		return transactionResponseDTO;

	  }

	private UserResponseDTO buildUserResponseDTO(User user) {
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		userResponseDTO.setFirstName(user.getFirstName());
		userResponseDTO.setLastName(user.getLastName());
		userResponseDTO.setCity(user.getCity());
		userResponseDTO.setEmail(user.getEmail());
		userResponseDTO.setPhone(user.getPhone());
		userResponseDTO.setAddressLine1(user.getAddressLine1());
		userResponseDTO.setAddressLine2(user.getAddressLine2());
		userResponseDTO.setAddressLine3(user.getAddressLine3());
		userResponseDTO.setZip(user.getZip());
		userResponseDTO.setMobile(user.getCell());
		userResponseDTO.setUsername(user.getUsername());
		userResponseDTO.setCustomerId(user.getCustomerId());
		userResponseDTO.setStatus(user.getStatus());
		userResponseDTO.setState(user.getState());
		userResponseDTO.setAddressLine2(user.getAddressLine2());
		userResponseDTO.setAddressLine3(user.getAddressLine3());
		return userResponseDTO;
	}

	private void sendMailIfApproved(User user) {
		if (UserStatus.APPROVED.getStatus().equals(user.getStatus())) {
			
			SendMailDTO sendMailDTO = new SendMailDTO();
			sendMailDTO.setToAddress(user.getEmail());
			sendMailDTO.setSubject("Your account is activated");
			sendMailDTO.setQueries("Dear Customer, you account has been successfully validated" + "" + "with username"
					+ sendMailDTO.getUsername() + " " + "Login to use INB services.");
			notificationService.sendEmail(sendMailDTO);
		}
	}

	private void sendMailIfRejected(User user) {
		if (UserStatus.REJECTED.getStatus().equals(user.getStatus())) {
			SendMailDTO sendMailDTO = new SendMailDTO();
			sendMailDTO.setToAddress(user.getEmail());
			sendMailDTO.setSubject("Your account is rejected");
			sendMailDTO.setQueries(
					"Dear Customer, your account is not being created due to some error. We are very sorry for the inconvinience.");
			notificationService.sendEmail(sendMailDTO);

		}
	}

	public void getAccountsByCustomer(long customerId) {
		// Find existingUser which need to be updated
		User existingUser = userRepository.findUserById(customerId);
		if (existingUser == null) {
			throw new NotFoundException("Customer Id is invalid");
		}

		List<UserAccount> userAccountList = userAccountRepository.findUserAccountByUser(existingUser);
	}

	@Override
	public void updateTransactionStatus(String status) {

		List<UserTransaction> userTransactionList = userTransactionRepository.findUserTransactionByStatus(status);

		for (UserTransaction userTransaction : userTransactionList) {

			UserAccount sourceAccount = userTransaction.getSourceAccount();
			UserAccount targetAccount = userTransaction.getTargetAccount();

			if ((sourceAccount.getAccountNumber() == targetAccount.getAccountNumber())) {

				userTransaction.setStatus(UserStatus.APPROVED.getStatus());
				targetAccount.setAccountBalance(targetAccount.getAccountBalance() + userTransaction.getAmount());
				userAccountRepository.save(targetAccount);
				userTransactionRepository.save(userTransaction);
			}
		}
	}

	
}
