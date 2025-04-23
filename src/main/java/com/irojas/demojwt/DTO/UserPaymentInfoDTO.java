package com.irojas.demojwt.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPaymentInfoDTO {
    private String planType;
    private String cardNumber;
}
