package com.goldencity.moneymanageapi.service;


import com.goldencity.moneymanageapi.dto.TransactionDTO;
import com.goldencity.moneymanageapi.entity.Transactions;
import com.goldencity.moneymanageapi.repository.TransactionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                        .transactionName(t.getTransactionName())
                        .category(t.getCategory())
                        .amount(t.getAmount())
                        .dateOfTransaction(t.getDateOfTransaction())
                        .creditDebit(t.getCreditDebit())
                        .transactionType(t.getTransactionType())
                        .transactionDescription(t.getTransactionDescription())
                        .build())
                .collect(Collectors.toList());

    }

    public TransactionDTO getTransaction(Long id) {
        Transactions transaction = transactionsRepo.getById(id);

        return TransactionDTO.builder()
                .id(transaction.getId())
                .transactionName(transaction.getTransactionName())
                .category(transaction.getCategory())
                .amount(transaction.getAmount())
                .dateOfTransaction(transaction.getDateOfTransaction())
                .creditDebit(transaction.getCreditDebit())
                .transactionType(transaction.getTransactionType())
                .transactionDescription(transaction.getTransactionDescription())
                .build();
    }

    public TransactionDTO addTransaction(TransactionDTO transactionDTO) {
        Transactions transaction
                = Transactions.builder()
                .transactionName(transactionDTO.getTransactionName())
                .category(transactionDTO.getCategory())
                .amount(transactionDTO.getAmount())
                .dateOfTransaction(transactionDTO.getDateOfTransaction())
                .creditDebit(transactionDTO.getCreditDebit())
                .transactionType(transactionDTO.getTransactionType())
                .transactionDescription(transactionDTO.getTransactionDescription())
                .build();

        transactionsRepo.save(transaction);

        transactionDTO.setId(transaction.getId());

        return transactionDTO;

    }

    public TransactionDTO updateTransaction(TransactionDTO dto, Long id) {

        Optional<Transactions> transaction = transactionsRepo.findById(id);

        transaction.ifPresent(t -> {
            t.setTransactionName(dto.getTransactionName());
            t.setCategory(dto.getCategory());
            t.setAmount(dto.getAmount());
            t.setDateOfTransaction(dto.getDateOfTransaction());
            t.setCreditDebit(dto.getCreditDebit());
            t.setTransactionType(dto.getTransactionType());
            t.setTransactionDescription(dto.getTransactionDescription());

            transactionsRepo.save(t);
        });

        return transaction.isPresent()? dto : null;
    }

    public void removeTransaction(Long id) {
        transactionsRepo.findById(id).ifPresent(transactionsRepo::delete);
    }

}
