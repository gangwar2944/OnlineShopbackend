package com.Shop.Ecommerce.auth;

import com.Shop.Ecommerce.Entity.Role;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String token;
    private Long id;
    private String firstname;
    private String email;
    private String lastname;
    private Date dob;
    private String region;

}
