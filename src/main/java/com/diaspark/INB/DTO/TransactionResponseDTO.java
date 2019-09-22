package com.diaspark.INB.DTO;

import java.sql.Date;

public class TransactionResponseDTO {
private String status;
private double amount;
private long targetAccount;
private long sourceAccount;
private long transId;
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
public long getTargetAccount() {
	return targetAccount;
}
public void setTargetAccount(long targetAccount) {
	this.targetAccount = targetAccount;
}

}
