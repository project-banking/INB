package com.diaspark.INB.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_transaction")
public class UserTransaction {

	@ManyToOne
	@JoinColumn(name = "source_account", referencedColumnName = "account_number")
	private UserAccount sourceAccount;

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

	@ManyToOne
	@JoinColumn(name = "target_account", referencedColumnName = "account_number")
	private UserAccount targetAccount;

	@Id
	@Column(name = "trans_id", unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transId;

	@Column(name = "trans_type", nullable = true, unique = true)
	private String transType;

	@Column(name = "trans_date", nullable = true, unique = true)
	private Date date;

	@Column(name = "amount", nullable = false)

	private double amount;
	@Column(name = "status", nullable = true)
	private String status;

	/*
	 * @Column(name = "source_account", nullable = false) private long
	 * sourceAccount;
	 */ public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	/*
	 * public long getSourceAccount() { return sourceAccount; } public void
	 * setSourceAccount(long sourceAccount) { this.sourceAccount = sourceAccount; }
	 * public long getTargetAccount() { return targetAccount; } public void
	 * setTargetAccount(long targetAccount) { this.targetAccount = targetAccount; }
	 * 
	 * @Column(name = "target_account", nullable = false) private long
	 * targetAccount;
	 * 
	 */

	public long getTransId() {
		return transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
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
