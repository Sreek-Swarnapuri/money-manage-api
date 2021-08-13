package com.goldencity.moneymanageapi.repository;

import com.goldencity.moneymanageapi.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepo extends JpaRepository<Transactions, Long> {
}
