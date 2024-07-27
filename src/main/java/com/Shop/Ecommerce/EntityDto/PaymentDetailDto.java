package com.Shop.Ecommerce.EntityDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetailDto {

    private String paymentMethod;
    private String status;
    private String paymentID;
    private String rozarpayPaymentLinkId;
    private String rozarpayPaymentLinkRefrenceId;
    private String rozarpayPaymentLinkStatus;
    private String rozarpayPaymentId;
}
