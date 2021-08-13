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
    @GeneratedValue(generator = "TRANACTIONS_SEQ")
    @SequenceGenerator(name = "TRANACTIONS_SEQ", sequenceName = "TRANACTIONS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "TRANSACTION_TYPE")
    private Character transactionType;

    @Column(name = "TRANSACTION_DESC")
    private String transactionDescription;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "DATE_OF_TRANSACTION", nullable = false)
    private Date dateOfTransaction;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private String createdDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "UPDATED_DATE")
    private String updatedDate;

}
