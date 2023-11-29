package com.tsports.Thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsData {

    private String tran_status,tran_gw,transaction_id,tran_date,
            card_type,reg_type,username;
    @Value("${amount.type:0.0}")
    private Double amount;
 @Value("${subscriber_id.type:0.0}")
    private Double subscriber_id;
 @Value("${device_type.type:0.0}")
    private Double device_type;
 @Value("${id.type:0.0}")
    private Integer id;

}
