package com.goldencity.moneymanageapi.service;


import com.goldencity.moneymanageapi.dto.TransactionDTO;
import com.goldencity.moneymanageapi.entity.Transactions;
import com.goldencity.moneymanageapi.repository.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionsService {

    @Autowired
    TransactionsRepo transactionsRepo;

    /**
     * Retrieves all the transactions that were performed
     *
     * @return List<TransactionsDTO>
     */
    public List<TransactionDTO> getAllTransactions() {

        List<Transactions> transactions = transactionsRepo.findAll();

        return transactions
                .stream()
                .map(t -> TransactionDTO
                        .builder()
                        .id(t.getId())
                        .transactionType(t.getTransactionType())
                        .dateOfTransaction(t.getDateOfTransaction())
                        .amount(t.getAmount())
                        .build())
                .collect(Collectors.toList());

    }


}
