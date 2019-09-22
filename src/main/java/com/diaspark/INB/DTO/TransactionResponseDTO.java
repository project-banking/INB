package com.diaspark.INB.DTO;

import java.sql.Date;

import com.diaspark.INB.entity.UserAccount;

public class TransactionResponseDTO {
private String status;
private double amount;
private UserAccount sourceAccount;
private UserAccount targetAccount;

public UserAccount getSourceAccount() {
	return sourceAccount;
}
public void setSourceAccount(UserAccount sourceAccount) {
	this.sourceAccount = sourceAccount;
}
public UserAccount getTargetAccount() {
	return targetAccount;
}
public void setTargetAccount(UserAccount targetAccount) {
	this.targetAccount = targetAccount;
}
private long transId;
public long getTransId() {
	return transId;
}
public void setTransId(long transId) {
	this.transId = transId;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
private Date date;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}

}
