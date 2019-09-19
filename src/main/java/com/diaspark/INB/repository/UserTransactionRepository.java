package com.diaspark.INB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diaspark.INB.entity.UserAccount;
import com.diaspark.INB.entity.UserTransaction;

@Repository
public interface UserTransactionRepository extends JpaRepository<UserTransaction, Double> {
    List<UserTransaction> findUserTransactionBySourceAccount(UserAccount userAccount);
}
