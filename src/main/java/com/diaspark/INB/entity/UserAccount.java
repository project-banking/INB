package com.diaspark.INB.entity;

import java.util.List;
import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.diaspark.INB.DTO.AccountResponseDTO;

@Entity
@Table(name="account")
public class UserAccount {
	
	//@Column(name="customer_id", unique = true,nullable=false)
	//private long id;
	@ManyToOne
	@JoinColumn(name="customer_id",referencedColumnName="customer_id")
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy="sourceAccount")
	private Set<UserTransaction> userTransaction; 
	
	
	public Set<UserTransaction> getUserTransaction() {
		return userTransaction;
	}
	public void setUserTransaction(Set<UserTransaction> userTransaction) {
		this.userTransaction = userTransaction;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Size(max = 20)
    @Column(name="account_number",nullable=false,unique=true)
    private  long accountNumber;
	@Column(name="account_type",nullable=true)
	private int accountType;
	@Column(name="balance",nullable=false)
	private double accountBalance;
	
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
}
