package com.goldencity.moneymanageapi.controller;

import com.goldencity.moneymanageapi.dto.TransactionDTO;
import com.goldencity.moneymanageapi.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable("id") Long id) {
        return ResponseEntity.ok(transactionsService.getTransaction(id));
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> addTransaction(@RequestBody TransactionDTO transaction) throws URISyntaxException {
        TransactionDTO t = transactionsService.addTransaction(transaction);
        return ResponseEntity.created(new URI(String.valueOf(t.getId()))).body(t);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionDTO> updateTransaction(@RequestBody TransactionDTO transaction, @PathVariable("id") Long id) {
        return ResponseEntity.ok(transactionsService.updateTransaction(transaction, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeTransaction(@PathVariable("id") Long id) {
        transactionsService.removeTransaction(id);
        return ResponseEntity.accepted().build();
    }

}
