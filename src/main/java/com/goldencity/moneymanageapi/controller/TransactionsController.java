package com.goldencity.moneymanageapi.controller;

import com.goldencity.moneymanageapi.dto.TransactionDTO;
import com.goldencity.moneymanageapi.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/transactions")
public class TransactionsController {

    @Autowired
    TransactionsService transactionsService;

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {

        return ResponseEntity.ok(transactionsService.getAllTransactions());
    }

}
