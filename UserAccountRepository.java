package com.diaspark.INB.repository;


import com.diaspark.INB.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	 

}
