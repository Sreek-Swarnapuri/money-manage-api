package com.goldencity.moneymanageapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    @ApiModelProperty(hidden = true)
    private Long id;

    private String transactionName;

    private String category;

    private BigDecimal amount;

    private Date dateOfTransaction;

    private Character creditDebit;

    private String transactionType;

    private String transactionDescription;

}
