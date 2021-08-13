package com.goldencity.moneymanageapi.dto;

import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private Long id;

    private Character transactionType;

    private String transactionDescription;

    private BigDecimal amount;

    private Date dateOfTransaction;

}
