package com.goldencity.moneymanageapi.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TRANSACTIONS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transactions {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "TRANSACTIONS_SEQ")
    @SequenceGenerator(name = "TRANSACTIONS_SEQ", sequenceName = "TRANSACTIONS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "TRANSACTION_NAME", nullable = false)
    private String transactionName;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "DATE_OF_TRANSACTION", nullable = false)
    private Date dateOfTransaction;

    @Column(name = "MODE_OF_PAYMENT", nullable = false)
    private String modeOfPayment;

    @Column(name = "CREDIT_DEBIT", nullable = false)
    private Character creditDebit;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @Column(name = "TRANSACTION_DESC")
    private String transactionDescription;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private String createdDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "UPDATED_DATE")
    private String updatedDate;

}
