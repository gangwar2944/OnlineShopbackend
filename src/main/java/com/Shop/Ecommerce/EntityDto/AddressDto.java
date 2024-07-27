package com.Shop.Ecommerce.EntityDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String city;
    private String country;
    private String landmark;
    private String area;
    private Long pinCode;
    private Long phoneNumber;
    private Long userId;
}
