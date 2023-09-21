package com.Shop.Ecommerce.auth;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Date dob;
    private String region;
}
