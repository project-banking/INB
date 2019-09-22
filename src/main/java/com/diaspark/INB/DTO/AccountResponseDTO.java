package com.diaspark.INB.DTO;

public class AccountResponseDTO {
private long accountNumber;
private double balance;
private int accountType;
public long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(long accountNumber) {
	this.accountNumber = accountNumber;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public int getAccountType() {
	return accountType;
}
public void setAccountType(int accountType) {
	this.accountType = accountType;
}
}
