package com.diaspark.INB.DTO;

import java.sql.Date;


public class TransactionDTO {
	
	 private String transType;
	 private Date date;
	 private double amount;
	 private String status;
	 private long sourceAccount;
	 private long targetAccount;
	 
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getSourceAccount() {
		return sourceAccount;
	}
	public void setSourceAccount(long sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	public long getTargetAccount() {
		return targetAccount;
	}
	public void setTargetAccount(long targetAccount) {
		this.targetAccount = targetAccount;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
