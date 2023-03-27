package com.Shop.Ecommerce.EntityDto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long userId;
    private String firstName;

    private String lastName;
    private String email;
    private String password;
}
