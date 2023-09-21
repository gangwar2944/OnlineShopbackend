package com.Shop.Ecommerce.EntityDto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String firstname;

    private String lastname;
    private String email;
    private String password;
    private Date dob;
    private String region;
}
